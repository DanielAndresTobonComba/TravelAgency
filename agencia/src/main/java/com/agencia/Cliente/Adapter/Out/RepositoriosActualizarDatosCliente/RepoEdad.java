package com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class RepoEdad {


    public void actualizarEdad (String edadNueva , String numeroDocumento) {

        System.out.println("LLEGUE A LA DB CON : " + edadNueva + numeroDocumento);


        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarEdadCliente (? , ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
            stmt.setString(2, edadNueva);
 
        
            //  System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al buscar el cliente");

                } else {
                    try (ResultSet rs = stmt.getResultSet()) {
                        System.out.println("\nCLIENTE ENCONTRADO");
                        
                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+-----------------------------+");
                        System.out.printf("| %-30s | %-5s | %-15s | %-20s | %-15s | %-70s |\n", "Nombre", "Edad", "TipoDocumento", "NumeroDocumento", "Usuario", "Contraseña");
                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+-----------------------------+");
                        
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

                if (mensaString.contains("edad")) {
                    System.out.println("Error la edad es invalida");
                }
            } catch (Exception e) {
                System.out.println("ERROR AL MODIFICAR LA EDAD DEL CLIENTE");
                
                e.printStackTrace();
            }
        
           
        
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
