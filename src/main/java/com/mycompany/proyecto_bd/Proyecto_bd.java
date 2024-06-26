/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_bd;

import java.sql.Connection;

/**
 *
 * @author utente
 */
public class Proyecto_bd {

    public static void main(String[] args) {
        Connection con = Conexion.conexionMySQL();
        Consultas cons = new Consultas();
        String tabla = "clave";
        cons.select(con, tabla);
        cons.mostrar();
    }
}
