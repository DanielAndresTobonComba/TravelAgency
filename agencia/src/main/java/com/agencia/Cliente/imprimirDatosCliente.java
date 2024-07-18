package com.agencia.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public class imprimirDatosCliente {

    public static void imprimir(CallableStatement stmt) throws SQLException {
        ResultSet rs = stmt.getResultSet();

        System.out.println("Entre");

        System.out.println("\nCLIENTE ENCONTRADO");
        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+");
        System.out.printf("| %-30s | %-5s | %-15s | %-20s | %-15s | %-20s |\n", "Nombre", "Edad", "TipoDocumento", "NumeroDocumento", "Usuario", "Contraseña");
        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+");
        
        while (rs.next()) {
            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");
            int tipoDocumento = rs.getInt("TipoDocumento_id");
            String documento = rs.getString("numeroDocumento");
            String usuario = rs.getString("usuario");
            String contraseña = rs.getString("contraseña");

            System.out.printf("| %-30s | %-5d | %-15d | %-20s | %-15s | %-20s |\n", nombre, edad, tipoDocumento, documento, usuario, contraseña);
        }

        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+");
    }
}
