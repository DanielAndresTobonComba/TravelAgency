package com.agencia.Tarifa.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Tarifa.Application.Service.InterfazConsultaTarifa;
import com.agencia.Tarifa.Utilities.imprimirDatosTarifa;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class repoConsultarTarifa implements InterfazConsultaTarifa {

    @Override
    public void consultarTarifa(int idTarifa) {
       
         CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call buscarTarifa (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setInt(1, idTarifa);
        
            System.out.println("Ejecutando el procedimiento almacenado de buscar tarifa...");

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al buscar la tarifa");
                } else {
                    imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa(); 
                    imprimirDatosTarifa.imprimir(stmt);
                }
            
                stmt.close();
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("id")) {
                    System.out.println("Error la id es invalido");
                }
            }
        
           
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
