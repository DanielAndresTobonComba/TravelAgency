package com.agencia.Cliente.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.mysql.cj.jdbc.CallableStatement;
public class existeCliente {

    public boolean verificarCliente(String numeroDocumento) {

        Scanner sc = new Scanner(System.in);

        
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call consultarCliente (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);

            System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            boolean hasResult = stmt.execute();

            if (!hasResult) {
                System.out.println("Error al buscar el cliente o no existe");
                return false;
            } else {
                try (ResultSet rs = stmt.getResultSet()) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("Cliente no encontrado en la base de datos");
                        return false;
                    }
                    
                    System.out.println("\nCLIENTE ENCONTRADO");
                        
                    System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+-----------------------------+");
                    System.out.printf("| %-30s | %-5s | %-15s | %-20s | %-15s | %-70s |\n", "Nombre", "Edad", "TipoDocumento", "NumeroDocumento", "Usuario", "Contraseña");
                    System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+-----------------------------+");

                    while (rs.next()) {
                        String nombre = rs.getString("nombre");
                        int edad = rs.getInt("edad");
                        int tipoDocumento = rs.getInt("TipoDocumento_id");
                        String documento = rs.getString("numeroDocumento");
                        String usuario = rs.getString("usuario");
                        String contraseña = rs.getString("contraseña");

                        System.out.printf("| %-30s | %-5d | %-15d | %-20s | %-15s | %-70s |\n", nombre, edad, tipoDocumento, documento, usuario, contraseña);
                    }

                    System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+----------------------------+");
                    System.out.println("\n\nPresiona enter para continuar");
                    sc.nextLine();
                }
            }
            
            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }
}
