package com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class RepoNombre {


    public void actualizarNombre (String nuevoNombre , String numeroDocumento) {

        System.out.println("LLEGUE A LA DB CON : " + nuevoNombre + numeroDocumento);


        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarNombreCliente (? , ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
            stmt.setString(2, PasswordEncripted.encript(nuevoNombre));
 
        
            //  System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al buscar el cliento o no existe");

                } else {
                    try (ResultSet rs = stmt.getResultSet()) {
                        System.out.println("\nCLIENTE ENCONTRADO");
                        
                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+");
                        System.out.printf("| %-30s | %-5s | %-15s | %-20s | %-15s | %-70s |\n", "Nombre", "Edad", "TipoDocumento", "NumeroDocumento", "Usuario", "Contraseña");
                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+");
                        
                        while (rs.next()) {
                            // Obtener y mostrar los datos del cliente creado 
                            String nombre = rs.getString("nombre");
                            int edad = rs.getInt("edad");
                            int tipoDocumento = rs.getInt("TipoDocumento_id");
                            String documento = rs.getString("numeroDocumento");
                            String usuario = rs.getString("usuario");
                            String contraseña = rs.getString("contraseña");
            
                            System.out.printf("| %-30s | %-5d | %-15d | %-20s | %-15s | %-70s |\n", nombre, edad, tipoDocumento, documento, usuario, contraseña);
                        }
                    }
                }
            
                stmt.close();
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("TipoDocumento_id")) {
                    System.out.println("Error el tipo de documento es invalido");
                }
            }
        
           
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        


    }


}


