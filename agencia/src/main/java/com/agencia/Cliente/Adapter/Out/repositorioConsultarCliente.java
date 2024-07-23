package com.agencia.Cliente.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;


import com.agencia.Cliente.Domian.Service.interfazConsultarCliente;
import com.agencia.Cliente.Utilities.imprimirEnPlacaCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.mysql.cj.jdbc.CallableStatement;

public class repositorioConsultarCliente implements interfazConsultarCliente {

    @Override
    public void consultarCliente(String numeroDocumento) {

        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {

            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call consultarCLiente (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
 
        
            System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            

            boolean hasResult = stmt.execute();
    
            if (!hasResult) {

                System.out.println("Error al buscar el cliento o no existe");

            } else {
                ResultSet rs = stmt.getResultSet();
                imprimirEnPlacaCliente imprimir = new imprimirEnPlacaCliente(); 

                imprimir.imprimir(rs);
                
                    
            }
                    
                
            
               
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();
    
                if (mensaString.contains("TipoDocumento_id")) {
                    System.out.println("Error el tipo de documento es invalido");
                }
            } 
            
            catch (Exception e) {
                e.printStackTrace();
            }
        
    }
        
}


