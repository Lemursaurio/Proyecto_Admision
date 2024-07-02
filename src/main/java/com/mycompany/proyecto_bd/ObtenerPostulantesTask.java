package com.mycompany.proyecto_bd;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 *
 * @author JeanSL
 */
public class ObtenerPostulantesTask implements Callable<Void> {
    private final Consultas cons;
    private final ArrayList<Postulante> listaPostulantes;

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
