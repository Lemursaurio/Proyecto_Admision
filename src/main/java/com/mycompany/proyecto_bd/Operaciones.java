/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_bd;

import java.util.ArrayList;

/**
 *
 * @author utente
 */
public class Operaciones {
    
    final double puntajePos = 20.0;
    final double puntajeNeg = 1.125; 
    
    ArrayList<Rango> listaRangos = new ArrayList<>();
    ArrayList<Postulante> listaPostulantes = new ArrayList<>();
    Consultas cons;

    public Operaciones(Consultas cons) {
        this.cons = cons;
    }    
    
    public void calcularResultados() {
        // Iniciar timer
        double tiempoInicio = System.nanoTime();
        
        // Obtener datos de rango
        obtenerRangos();
        
        // Obtener datos de postulante
        obtenerPostulantes();
        
        // Calcular nota
        asignarNota();
        
        // Mostrar postulantes
        for (int i = 0 ; i < listaPostulantes.size() ; i++)
        {
            listaPostulantes.get(i).mostrarPostulante();
        }
        
        // Tiempo total
        double tiempoFinal = System.nanoTime();
        
        System.out.println("\nEl proceso tomó " + String.format("%.9f", (tiempoFinal - tiempoInicio)/1_000_000_000.0) + " segundos");
    }
    
    public void obtenerRangos() {
        cons.select("SELECT r.ran_iIndiceMinimo, r.ran_iIndiceMaximo, c.cla_vcRespuesta FROM rango r JOIN clave c USING (cla_iPosicion)", false);      
        cons.llenarArrayList(listaRangos, "rango");    
    }
    
    public void obtenerPostulantes() {
        cons.select("SELECT p.cod_vcCodigo, p.esc_vcCodigo, r.ide_iIndice, r.res_vcRespuesta FROM postulante p JOIN identificacion USING (cod_vcCodigo) JOIN respuesta r USING (ide_iIndice)",
                    false);
        cons.llenarArrayList(listaPostulantes, "postulante");
    }
    
    public void asignarNota() {
        String claveActual;
        String respuestaActual;
        double[] notasActual;
        for (int i = 0 ; i < listaPostulantes.size() ; i++)
        {
            respuestaActual = listaPostulantes.get(i).getRespuestas();
            // Buscar qué claves usar
            claveActual = obtenerClave(listaPostulantes.get(i).getCodRespuesta());
            // Comparar con respuestas de postulante
            notasActual = calcularNota(claveActual, respuestaActual);
            // Asignar notas
            listaPostulantes.get(i).setNotaAptitud(notasActual[0]);
            listaPostulantes.get(i).setNotaConocimientos(notasActual[1]);
            listaPostulantes.get(i).setNotaFinal(notasActual[2]);
        }      
    }
    
    public String obtenerClave(int clave) {
        String claveRes = "";
        int rangoInf;
        int rangoSup;
        for (int i = 0 ; i < listaRangos.size() ; i++)
        {
            rangoInf = listaRangos.get(i).getInicio();
            rangoSup = listaRangos.get(i).getFin();
            
            if (clave >= rangoInf && clave <= rangoSup) 
            {
                claveRes = listaRangos.get(i).getRespuesta();
            }
        }
        return claveRes;
    }
    
    public double[] calcularNota(String clave, String respuesta) {
        double[] notas = {0, 0, 0};
        
        // Sección Aptitud
        for (int i = 0 ; i < clave.length() - 70 ; i++)
        {
            if (respuesta.charAt(i) == ' ')
                notas[0] += 0;          
            else if (clave.charAt(i) == respuesta.charAt(i))
                notas[0] += puntajePos;
            else
                notas[0] -= puntajeNeg;
        } 
        // Sección Conocimientos
        for (int i = 30 ; i < clave.length() ; i++)
        {
            if (respuesta.charAt(i) == ' ')
                notas[1] += 0;          
            else if (clave.charAt(i) == respuesta.charAt(i))
                notas[1] += puntajePos;
            else
                notas[1] -= puntajeNeg;
        } 
        // Total
        notas[2] = notas[0] + notas[1];
        return notas;
    }
}
