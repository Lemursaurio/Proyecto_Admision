package com.mycompany.proyecto_bd;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author JeanSL
 */
public class ObtenerRangosTask implements Callable<Void> {
    private Consultas cons;
    private ArrayList<Rango> listaRangos;

    public ObtenerRangosTask(Consultas cons, ArrayList<Rango> listaRangos) {
        this.cons = cons;
        this.listaRangos = listaRangos;
    }


    @Override
    public Void call() throws Exception {
        cons.select("SELECT r.ran_iIndiceMinimo, r.ran_iIndiceMaximo, c.cla_vcRespuesta FROM rango r JOIN clave c USING (cla_iPosicion)", false);
        cons.llenarArrayList(listaRangos, "rango");
        return null;
    }
}
