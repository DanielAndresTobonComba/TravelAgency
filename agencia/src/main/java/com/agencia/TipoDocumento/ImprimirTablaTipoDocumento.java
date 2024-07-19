package com.agencia.TipoDocumento;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class ImprimirTablaTipoDocumento {

    public static void imprimir(CallableStatement stmt) throws SQLException {

        ResultSet rs = stmt.getResultSet();

        System.out.println("\nTipos de Documento encontrado");
        System.out.println("+------+-----------------------------------------------+");
        System.out.printf("| %-4s | %-45s |\n", "ID", "Nombre");
        System.out.println("+------+-----------------------------------------------+");
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");

            System.out.printf("| %-4d | %-45s |\n", id, nombre);
        }

        System.out.println("+------+-----------------------------------------------+");
    }
}


