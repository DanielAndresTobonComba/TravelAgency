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

            boolean hasResult = stmt.execute();
            
            if (hasResult) {
                ResultSet rs = stmt.getResultSet();

                if (rs.next()) {
                    // Si hay resultado, imprimir los datos de la tarifa
                    imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa();
                    imprimirDatosTarifa.imprimir(rs);

                    existe = true;
                } else {
                    // Si no hay resultados, imprimir el mensaje de error
                    System.out.println("No se encontró ninguna tarifa con el ID ingresado.");
                }
                
            } else {
                System.out.println("Error al encontrar la tarifa");
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
