/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_bd;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author utente
 */
public class Consultas {
    
    ResultSet resultado;
    Connection conexion;
    
    public Consultas(Connection conexion)
    {
        this.conexion = conexion;
        select("area");
    }
    
    public void select(String tabla)
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
    
    public void settearColumnas(DefaultTableModel modelo)
    {
        try 
        {
            // getMedaData devuelve un objeto ResultMetaData, en el cual las columnas empiezan con índice 1 
            int numColumnas = resultado.getMetaData().getColumnCount();
            
            modelo.setColumnCount(numColumnas);
            String [] nombreColumnas = new String[numColumnas];

            for (int i = 1; i <= numColumnas; i++) 
            {
                nombreColumnas[i-1] = resultado.getMetaData().getColumnName(i); 
            }
            
            modelo.setColumnIdentifiers(nombreColumnas);
        } 
        catch (SQLException e) 
        {
            System.out.println("SQLException: " + e.getMessage());
        }
    }
    
    public void settearFilas(DefaultTableModel modelo)
    {
        try 
        {
            int numColumnas = modelo.getColumnCount();
            String[] filaActual = new String[numColumnas];
            // Iterar a través del ResultSet (next es false cuando ya no hay columnas)
            while (resultado.next()) 
            {
                for (int i = 1; i <= numColumnas; i++) 
                {
                    filaActual[i-1] = resultado.getString(i);
                }
                
                modelo.addRow(filaActual);
            }
        } 
        catch (SQLException e) 
        {
            System.out.println("SQLException: " + e.getMessage());
        }   
    }
}
