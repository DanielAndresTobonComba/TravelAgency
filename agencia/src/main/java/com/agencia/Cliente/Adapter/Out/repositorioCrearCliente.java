package com.agencia.Cliente.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.Cliente.Domian.Entity.Cliente;
import com.agencia.Cliente.Domian.Service.interfazCrearCliente;
import com.agencia.Cliente.Utilities.imprimirEnPlacaCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class repositorioCrearCliente implements interfazCrearCliente {

    @Override
    public void crearCLiente(Cliente cliente) {

        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call crearCliente (?, ?, ?, ?, ?, ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, cliente.getNombre());
            stmt.setInt(2, cliente.getEdad());
            stmt.setInt(3, cliente.getTipoDocumento());
            stmt.setString(4, cliente.getNumeroDocumento());
            stmt.setString(5, cliente.getUsuario());
            stmt.setString(6, PasswordEncripted.encript(cliente.getContraseña()));
        
            System.out.println("Ejecutando el procedimiento almacenado de crearCliente...");

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al crear el Cliente");
                    
                } else {    

                        ResultSet rs = stmt.getResultSet();
                        imprimirEnPlacaCliente imprimirEnPlacaCLiente = new imprimirEnPlacaCliente(); 

                        imprimirEnPlacaCLiente.imprimir(rs);

/*                     try () {
                        System.out.println("\nCLIENTE CREADO");
                        
                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+");
                        System.out.printf("| %-30s | %-5s | %-15s | %-20s | %-20s | %-70s |\n", "Nombre", "Edad", "TipoDocumento", "NumeroDocumento", "Usuario", "Contraseña");
                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+-------------------+-------------------+");
                        
                        while (rs.next()) {
                            // Obtener y mostrar los datos del cliente creado
                            String nombre = rs.getString("nombre");
                            int edad = rs.getInt("edad");
                            int tipoDocumento = rs.getInt("TipoDocumento_id");
                            String numeroDocumento = rs.getString("numeroDocumento");
                            String usuario = rs.getString("usuario");
                            String contraseña = rs.getString("contraseña");
            
                            System.out.printf("| %-30s | %-5d | %-15d | %-20s | %-20s | %-70s |\n", nombre, edad, tipoDocumento, numeroDocumento, usuario, contraseña);
                        }
                    } */
                }
            
                
                
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
