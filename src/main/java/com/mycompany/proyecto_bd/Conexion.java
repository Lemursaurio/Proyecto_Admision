/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_bd;

/**
 *
 * @author utente
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 


public class Conexion {
    
    private static void CargarDriver() 
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } 
        catch (Exception e)
        {
            System.out.println("Ocurrió un error al cargar el driver");
        }
    }
    
    public static Connection conexionMySQL()
    {
        Connection conexion = null;
        CargarDriver();
        
        String hostname = "localhost";
        String puerto = "3306";
        String database = "admision_martes";
        String url = "jdbc:mysql://" + hostname + ":" + puerto + "/" + database + "?userSSL=false";
        
        try
        {
            conexion = DriverManager.getConnection(url, "root", "root");
        }
        catch (SQLException e)
        {
            System.out.println("Ocurrió un error al establecer la conexión");
        }
        
        return conexion;
    }
}
