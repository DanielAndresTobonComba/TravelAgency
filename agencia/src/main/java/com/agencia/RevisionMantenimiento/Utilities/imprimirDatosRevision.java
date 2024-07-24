package com.agencia.RevisionMantenimiento.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.AbstractClasses.imprimirTabla;
import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;

public class imprimirDatosRevision extends imprimirTabla{

    @Override
    public void imprimir(ResultSet rs) throws SQLException {

        System.out.println("\nREVISIÓN ENCONTRADA");

        System.out.println("+----------------+----------------+------------+--------------------------------------------------------------------------------------+");
        System.out.printf("| %-15s | %-15s | %-12s | %-80s |\n", 
            "Id Revision", "Placa Avion", "Fecha", "Descripción");
        System.out.println("+----------------+----------------+------------+--------------------------------------------------------------------------------------+");
        
        while (rs.next()) {
            int id = rs.getInt("idRevision");
            String idAvion = rs.getString("Placa_Avion");
            String fecha = rs.getString("Fecha"); 
            String descripcion = rs.getString("Descripcion");
        
            System.out.printf("| %-15d | %-15s | %-12s | %-80s |\n", 
                id, idAvion, fecha, descripcion);
        }
        
        System.out.println("+----------------+----------------+------------+--------------------------------------------------------------------------------------+");
        
        
    }

}
