package com.mycompany.proyecto_bd;

import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author JeanSL
 */
public class CalculoNotaTask extends RecursiveTask<Void>{
    private static final int THRESHOLD = 4; // Umbral para dividir tareas
    private ArrayList<Postulante> postulantes;
    private final int start;
    private final int end;
    private ArrayList<Rango> listaRangos;
    private OperacionesParalela operaciones;
    
    public CalculoNotaTask(ArrayList<Postulante> postulantes, int start, int end, ArrayList<Rango> listaRangos, OperacionesParalela operaciones) {
        this.postulantes = postulantes;
        this.start = start;
        this.end = end;
        this.listaRangos = listaRangos;
        this.operaciones = operaciones;
    }
    
    @Override
    protected Void compute() {
        if (end - start <= THRESHOLD) {
            for (int i = start; i < end; i++) {
                Postulante postulante = postulantes.get(i);
                String claveActual = operaciones.obtenerClave(postulante.getCodRespuesta());
                double[] notasActual = operaciones.calcularNota(claveActual, postulante.getRespuestas());
                postulante.setNotaAptitud(notasActual[0]);
                postulante.setNotaConocimientos(notasActual[1]);
                postulante.setNotaFinal(notasActual[2]);
            }
        } else {
            int mid = (start + end) / 2;
            CalculoNotaTask leftTask = new CalculoNotaTask(postulantes, start, mid, listaRangos, operaciones);
            CalculoNotaTask rightTask = new CalculoNotaTask(postulantes, mid, end, listaRangos, operaciones);
            invokeAll(leftTask, rightTask);
        }
        return null;
    }

}
