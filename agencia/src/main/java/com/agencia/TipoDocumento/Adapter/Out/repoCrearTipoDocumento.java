package com.agencia.TipoDocumento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.TipoDocumento.ImprimirTablaTipoDocumento;
import com.agencia.TipoDocumento.Domain.Entity.TipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazCrearTipoDocumento;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class repoCrearTipoDocumento implements interfazCrearTipoDocumento{

    @Override
    public void crearTipoDocumento(TipoDocumento entidad) {

                CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call crearTipoDocumento (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, entidad.getNombre());

        
            System.out.println("Ejecutando el procedimiento almacenado de crear tipo de documento...");

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al crear el tipo de documento");

                } else {

                    System.out.println("TIPO DE DOCUMENTO CREADO CORECTAMENTE");
                    
                    ImprimirTablaTipoDocumento imprimirTabla = new ImprimirTablaTipoDocumento(); 
                    imprimirTabla.imprimir(stmt);


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
