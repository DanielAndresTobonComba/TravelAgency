package com.agencia.Tarifa.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.AbstractClasses.imprimirTabla;
import com.mysql.cj.jdbc.CallableStatement;

public class imprimirDatosTarifa extends imprimirTabla {

    @Override
    public void imprimir(CallableStatement stmt) throws SQLException {

        ResultSet rs = stmt.getResultSet();

        System.out.println("\nTARIFA ENCONTRADA");
        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+----------------------------+");
        System.out.printf("| %-10s | %-30s | %-30s | %-15s | %-7s |\n", "id", "Descripcion", "Detalles", "Precio Base", "Usuario", "Impuesto");
        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+----------------------------+");
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String descripcion = rs.getString("descripcion");
            String detalle = rs.getString("detalle");
            Double precioBase = rs.getDouble("precioBase");
            Double impuesto = rs.getDouble("impuesto");

            System.out.printf("| %-10d | %-30s | %-30s | %-15.2f | %-7.2f|\n", id, descripcion, detalle, precioBase, impuesto);
        }

        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+----------------------------+");
    }

    

}
