/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author utente
 */
public class Consultas {
    
    ResultSet resultado = null;
    
    public void select(Connection conexion, String tabla)
    {
        Statement consulta = null;
        
        try 
        {
            consulta = conexion.createStatement();
            resultado = consulta.executeQuery("SELECT * FROM " + tabla);
        } 
        catch (SQLException e) 
        {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    
    public void mostrar()
    {        
        try 
        {
            // Obtener la información de las columnas
            int columnCount = resultado.getMetaData().getColumnCount();

            // Mostrar los nombres de las columnas
            for (int i = 1; i <= columnCount; i++) 
            {
                System.out.print(resultado.getMetaData().getColumnName(i) + "\t");
            }
            System.out.println();

            // Iterar a través del ResultSet y mostrar los resultados
            while (resultado.next()) 
            {
                for (int i = 1; i <= columnCount; i++) 
                {
                    System.out.print(resultado.getString(i) + "\t");
                }
                System.out.println();
            }
        } 
        catch (NullPointerException e) 
        {
            System.out.println("No se ha hecho una consulta previamente");
        }
        catch (SQLException e)
        {
            System.out.println("Ocurrió un error al leer el resultset");
        }
    }
}
