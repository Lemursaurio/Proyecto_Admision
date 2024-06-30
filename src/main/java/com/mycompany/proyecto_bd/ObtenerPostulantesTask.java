package com.mycompany.proyecto_bd;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author JeanSL
 */
public class ObtenerPostulantesTask implements Callable<Void> {
    private Consultas cons;
    private ArrayList<Postulante> listaPostulantes;

    public ObtenerPostulantesTask(Consultas cons, ArrayList<Postulante> listaPostulantes) {
        this.cons = cons;
        this.listaPostulantes = listaPostulantes;
    }


    @Override
    public Void call() throws Exception {
        cons.select("SELECT p.cod_vcCodigo, p.esc_vcCodigo, r.ide_iIndice, r.res_vcRespuesta FROM postulante p JOIN identificacion USING (cod_vcCodigo) JOIN respuesta r USING (ide_iIndice)", false);
        cons.llenarArrayList(listaPostulantes, "postulante");
        return null;
    }

}
