package com.agencia.Tarifa.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.AbstractClasses.verificarExistencia;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Tarifa.Utilities.imprimirDatosTarifa;

import com.mysql.cj.jdbc.CallableStatement;

public class existeTarifa extends verificarExistencia {

    @Override
    
    public boolean verficiar(String id) {
        boolean existe = false;

        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call buscarTarifa(?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setInt(1, Integer.valueOf(id));
            System.out.println("Buscando tarifa con la..." + id);

            
            try {
                
                boolean hasResult = stmt.execute();

                if (!hasResult) {

                    System.out.println("Error al encontrar la tarifa");
                    return existe;
                
                } else {

                    ResultSet rs = stmt.getResultSet();
                    imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa();
                    imprimirDatosTarifa.imprimir(rs);
                    return true;
                }

                


            } catch (Exception e) {
                System.out.println("Error " + e);
            }
            
        } catch (NumberFormatException a) {
            System.out.println("Error con el numero de tarifa ingresado ");
        }
        
        catch (SQLIntegrityConstraintViolationException b) {
            String mensaString = b.getMessage();
            if (mensaString.contains("id")) {
                System.out.println("Error con el id ingresado");
            }
        } catch (Exception e) {
            System.out.println("Error al buscar la tarifa...");
            e.printStackTrace();
        } 

        return existe;
    }
}
