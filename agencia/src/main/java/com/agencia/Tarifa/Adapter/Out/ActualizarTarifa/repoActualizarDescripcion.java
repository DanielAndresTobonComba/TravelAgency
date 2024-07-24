package com.agencia.Tarifa.Adapter.Out.ActualizarTarifa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Tarifa.Utilities.imprimirDatosTarifa;
import com.mysql.cj.jdbc.CallableStatement;

public class repoActualizarDescripcion {

    public void ejecutarActualizarDescripcion (String numeroTarifa ,String nuevaDescripcion) {

        Scanner sc = new Scanner(System.in);
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        if (nuevaDescripcion.length() > 50) {
            System.out.println("La longitud de la descripción excede el rango (50)");
            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainTarifa.main(null);
        }

        try {
            
           Connection connection =  DataBaseConfig.DBconnection;
           imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa(); 

           String sql = "{call actualizarDescripcionTarifa (? , ?)}";
           stmt = (CallableStatement) connection.prepareCall(sql);
       
           stmt.setInt(1, Integer.valueOf(numeroTarifa));
           stmt.setString(2, nuevaDescripcion);

           boolean hasResult = stmt.execute();

           if (!hasResult) {

            System.out.println("No se encontró ninguna tarifa con el ID ingresado.");
            
        
            } else {
                ResultSet rs = stmt.getResultSet();
                imprimirDatosTarifa.imprimir(rs);
                System.out.println("TARIFA ACTUALIZADA CORRECTAMENTE");
            }


        // El try me jode el stmt nose porque 
        //    try {

                
        //     ResultSet rs = stmt.getResultSet();
    
        //     if (!hasResult) {

        //         System.out.println("Error al actualizar la descripción");

        //     } else {
        //         System.out.println("PRUEBAAAA");
        //         imprimirDatosTarifa.imprimir(rs);
        //     }
        
            
            
        // } catch (SQLIntegrityConstraintViolationException b) {
        //     String mensaString = b.getMessage();

        //     if (mensaString.contains("descripcion")) {
        //         System.out.println("Error con la descripción ingresada");
        //     }
        // }


        }    
        catch (SQLIntegrityConstraintViolationException b) {
            String mensaString = b.getMessage();
            if (mensaString.contains("descripcion")) {
                System.out.println("Error con la descripción ingresada");
            }
        
        }catch (Exception e) {
            System.err.println("Error con los datos ingresados.");
            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainTarifa.main(null);
        }
        
    }
        
}
