package com.mycompany.proyecto_bd;

import java.util.ArrayList;

/**
 *
 * @author JeanSL
 */
public class ObtenerRangosThread extends Thread{
    private Consultas cons;
    private ArrayList<Rango> listaRangos;

    public ObtenerRangosThread(Consultas cons, ArrayList<Rango> listaRangos) {
        this.cons = cons;
        this.listaRangos = listaRangos;
    }

    @Override
    public void run() {
        cons.select("SELECT r.ran_iIndiceMinimo, r.ran_iIndiceMaximo, c.cla_vcRespuesta FROM rango r JOIN clave c USING (cla_iPosicion)", false);
        cons.llenarArrayList(listaRangos, "rango");
    }
}
