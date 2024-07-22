package com.agencia.Tarifa.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Tarifa.Application.Service.InterfazAgregarTarifa;
import com.agencia.Tarifa.Domain.Tarifa;
import com.agencia.Tarifa.Utilities.imprimirDatosTarifa;

import com.mysql.cj.jdbc.CallableStatement;

public class repoAgregarTarifa implements InterfazAgregarTarifa {

    @Override
    public void agregar(Tarifa tarifa) {
        System.out.println("llegue a db agregar tarifa");

        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call crearTarifa (?, ?, ?, ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, tarifa.getDescripcion());
            stmt.setString(2, tarifa.getDetalle());
            stmt.setDouble(3 , tarifa.getPrecioBase());
            stmt.setDouble(4 , tarifa.getImpuesto());


            System.out.println("Ejecutando el procedimiento almacenado de crear la tarifa...");

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al crear la tarifa");

                } else {

                    ResultSet rs = stmt.getResultSet();
                    imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa(); 
                    imprimirDatosTarifa.imprimir(rs);
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
