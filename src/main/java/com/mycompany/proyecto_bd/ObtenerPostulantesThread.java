package com.mycompany.proyecto_bd;

import java.util.ArrayList;

/**
 *
 * @author JeanSL
 */
public class ObtenerPostulantesThread extends Thread {
    private Consultas cons;
    private ArrayList<Postulante> listaPostulantes;

    public ObtenerPostulantesThread(Consultas cons, ArrayList<Postulante> listaPostulantes) {
        this.cons = cons;
        this.listaPostulantes = listaPostulantes;
    }

    @Override
    public void run() {
        cons.select("SELECT p.cod_vcCodigo, p.esc_vcCodigo, r.ide_iIndice, r.res_vcRespuesta FROM postulante p JOIN identificacion USING (cod_vcCodigo) JOIN respuesta r USING (ide_iIndice)", false);
        cons.llenarArrayList(listaPostulantes, "postulante");
    }
}
