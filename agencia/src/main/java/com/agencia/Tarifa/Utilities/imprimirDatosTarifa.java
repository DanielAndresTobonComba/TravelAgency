package com.agencia.Tarifa.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.AbstractClasses.imprimirTabla;


public class imprimirDatosTarifa extends imprimirTabla {

    @Override
    public void imprimir(ResultSet rs) throws SQLException {



        System.out.println("\nTARIFA ENCONTRADA");
        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+----------------------------+");
        System.out.printf("| %-10s | %-50s | %-50s | %-15s | %-15s |\n", "id", "Descripcion", "Detalles", "Precio Base", "Impuesto");
        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+----------------------------+");

        


        do {
            int id = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            String detalle = rs.getString("detalle");
            Double precioBase = rs.getDouble("precioBase");
            Double impuesto = rs.getDouble("impuesto");

            System.out.printf("| %-10d | %-50s | %-50s | %-15.2f | %-16.2f|\n", id, descripcion, detalle, precioBase, impuesto);
        } while (rs.next());
        
        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+----------------------------+");

    }

    

}
