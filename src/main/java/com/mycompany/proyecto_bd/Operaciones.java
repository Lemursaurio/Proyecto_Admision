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
    
    ArrayList<Rango> listRangos = new ArrayList<>();
    ArrayList<Postulante> listPostulantes = new ArrayList<>();
    Consultas cons;

    public Operaciones(Consultas cons) {
        this.cons = cons;
    }    
    
    public void calcularResultados() {
        // Obtener datos de rango
        obtenerRangos();
        
        // Obtener datos de postulante
        obtenerPostulantes();
        
        
    }
    
    public void obtenerRangos() {
        cons.select("SELECT r.ran_iIndiceMinimo, r.ran_iIndiceMaximo, c.cla_vcRespuesta FROM rango r JOIN clave c USING (cla_iPosicion)", false);      
        cons.llenarArrayList(listRangos, "rango");    
        // Mostrar rangos
        for (int i = 0 ; i < listRangos.size() ; i++)
        {
            listRangos.get(i).mostrarRango();
        }
    }
    
    public void obtenerPostulantes() {
        cons.select("SELECT p.cod_vcCodigo, p.esc_vcCodigo, r.ide_iIndice, r.res_vcRespuesta FROM postulante p JOIN identificacion USING (cod_vcCodigo) JOIN respuesta r USING (ide_iIndice)",
                    false);
        cons.llenarArrayList(listPostulantes, "postulante");
        // Mostrar postulantes
        System.out.println();
        for (int i = 0 ; i < listPostulantes.size() ; i++)
        {
            listPostulantes.get(i).mostrarPostulante();
        }
    }
    
}
