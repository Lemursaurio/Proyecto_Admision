/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_bd;

/**
 *
 * @author utente
 */
public class Postulante {
    
    private int codPostulante;
    private int codEscuela;
    private int codRespuesta;
    private String respuestas;
    private double notaAptitud;
    private double notaConocimientos;
    private double notaFinal;

    public Postulante(String... atributos) {
        this.codPostulante = Integer.parseInt(atributos[0]);
        this.codEscuela = Integer.parseInt(atributos[1]);
        this.codRespuesta = Integer.parseInt(atributos[2]);
        this.respuestas = atributos[3];
    }

    public int getCodPostulante() {
        return codPostulante;
    }

    public void setCodPostulante(int codPostulante) {
        this.codPostulante = codPostulante;
    }

    public int getCodEscuela() {
        return codEscuela;
    }

    public void setCodEscuela(int codEscuela) {
        this.codEscuela = codEscuela;
    }

    public int getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(int codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String respuestas) {
        this.respuestas = respuestas;
    }    

    public double getNotaAptitud() {
        return notaAptitud;
    }

    public void setNotaAptitud(double notaAptitud) {
        this.notaAptitud = notaAptitud;
    }

    public double getNotaConocimientos() {
        return notaConocimientos;
    }

    public void setNotaConocimientos(double notaConocimientos) {
        this.notaConocimientos = notaConocimientos;
    }
    
    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double nota) {
        this.notaFinal = nota;
    }
    
    public void mostrarPostulante() {
        System.out.println(this.codPostulante + "\t" + this.codEscuela + "\t" + this.codRespuesta + "\t" + this.respuestas 
                           + "\t" + this.notaAptitud + "\t\t" + this.notaConocimientos +"\t\t" + this.notaFinal);
    }
    
}
