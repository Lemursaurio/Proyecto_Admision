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
    
    int codPostulante;
    int codEscuela;
    int codRespuesta;
    String respuestas;

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
    
    public void mostrarPostulante() {
        System.out.println(this.codPostulante + "\t" + this.codEscuela + "\t" + this.codRespuesta + "\t" + this.respuestas);
    }
    
}
