package com.agencia.RevisionMantenimiento.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.AbstractClasses.imprimirTabla;

public class imprimirTablaDatosRevision extends imprimirTabla {

    @Override
    public void imprimir(ResultSet rs) throws SQLException {


        System.out.println("\nREVISIÓN ENCONTRADA");

        System.out.println("+------------+------------+----------+--------------------------------------------------+");
        System.out.printf("| %-10s | %-10s | %-8s | %-50s |\n", 
            "Id", "Fecha", "Avion ID", "Descripción");
        System.out.println("+------------+------------+----------+--------------------------------------------------+");

        while (rs.next()) {
            int id = rs.getInt("id");
            String fecha = rs.getString("fecha");
            int avionId = rs.getInt("Avion_id");
            String descripcion = rs.getString("descripcion");

            System.out.printf("| %-10d | %-10s | %-8d | %-50s |\n", 
                id, fecha, avionId, descripcion);
        }

        System.out.println("+------------+------------+----------+--------------------------------------------------+");
    }

}
