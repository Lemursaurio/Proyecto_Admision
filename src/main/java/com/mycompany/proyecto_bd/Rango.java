/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_bd;

/**
 *
 * @author utente
 */
public class Rango {
    
    private int inicio;
    private int fin;
    private String respuesta;

    public Rango(String... atributos) {
        this.inicio = Integer.parseInt(atributos[0]);
        this.fin = Integer.parseInt(atributos[1]);
        this.respuesta = atributos[2];
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public void mostrarRango() {
        System.out.println(this.inicio + "\t" + this.fin + "\t" + this.respuesta);
    }
    
}
