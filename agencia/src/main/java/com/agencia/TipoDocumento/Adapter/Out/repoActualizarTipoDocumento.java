package com.agencia.TipoDocumento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.TipoDocumento.ImprimirTablaTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazActualizarTipoDocumento;
import com.mysql.cj.jdbc.CallableStatement;

public class repoActualizarTipoDocumento implements 
interfazActualizarTipoDocumento {

    @Override
    public void actualizarTipoDocumento(int numeroTipoDocumento , String nuevoNombre ) {


        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarNombreTipoDocumento (? , ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setInt(1, numeroTipoDocumento);
            stmt.setString(2, nuevoNombre);

 
        
            System.out.println("Buscando el tipo de documento con el id..." + numeroTipoDocumento );

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al actualizar el nombre del tipo de documento");

                } else {
                    ResultSet rs = stmt.getResultSet();
                    ImprimirTablaTipoDocumento imprimirTabla = new ImprimirTablaTipoDocumento(); 
                    imprimirTabla.imprimir(rs);
                }
            
                
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("nombre")) {
                    System.out.println("Error con el id del tipo de documento ");
                }
            }
        
           
        
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}


