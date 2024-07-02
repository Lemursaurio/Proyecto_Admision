package com.mycompany.proyecto_bd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;

public class OperacionesParalela {

    final double puntajePos = 20.0;
    final double puntajeNeg = 1.125;

    ArrayList<Rango> listaRangos = new ArrayList<>();
    ArrayList<Postulante> listaPostulantes = new ArrayList<>();
    Consultas consA;
    Consultas consB;

    public OperacionesParalela(Consultas consA, Consultas consB) {
        this.consA = consA;
        this.consB = consB;
    }

    public void calcularResultados() {
        double tiempoInicio = System.nanoTime();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ObtenerRangosTask obtenerRangosTask = new ObtenerRangosTask(consA, listaRangos);
        ObtenerPostulantesTask obtenerPostulantesTask = new ObtenerPostulantesTask(consB, listaPostulantes);

        List<Callable<Void>> tasks = Arrays.asList(obtenerRangosTask, obtenerPostulantesTask);
        forkJoinPool.invokeAll(tasks);

        asignarNota();
//        for (int i = 0; i < listaPostulantes.size(); i++) {
//            listaPostulantes.get(i).mostrarPostulante();
//        }
        double tiempoFinal = System.nanoTime();
        System.out.println("\nEl proceso PP tomó " + String.format("%.9f", (tiempoFinal - tiempoInicio) / 1_000_000_000.0) + " segundos");
    }

    public void asignarNota() {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CalculoNotaTask task = new CalculoNotaTask(listaPostulantes, 0, listaPostulantes.size(), listaRangos, this);
        forkJoinPool.invoke(task);
    }

    public String obtenerClave(int clave) {
        String claveRes = "";
        int rangoInf;
        int rangoSup;
        for (int i = 0; i < listaRangos.size(); i++) {
            rangoInf = listaRangos.get(i).getInicio();
            rangoSup = listaRangos.get(i).getFin();
            if (clave >= rangoInf && clave <= rangoSup) {
                claveRes = listaRangos.get(i).getRespuesta();
            }
        }
        return claveRes;
    }

    public double[] calcularNota(String clave, String respuesta) {
        double[] notas = {0, 0, 0};
        for (int i = 0; i < clave.length() - 70; i++) {
            if (respuesta.charAt(i) == ' ') {
                notas[0] += 0;
            } else if (clave.charAt(i) == respuesta.charAt(i)) {
                notas[0] += puntajePos;
            } else {
                notas[0] -= puntajeNeg;
            }
        }
        for (int i = 30; i < clave.length(); i++) {
            if (respuesta.charAt(i) == ' ') {
                notas[1] += 0;
            } else if (clave.charAt(i) == respuesta.charAt(i)) {
                notas[1] += puntajePos;
            } else {
                notas[1] -= puntajeNeg;
            }
        }
        notas[2] = notas[0] + notas[1];
        return notas;
    }
}
