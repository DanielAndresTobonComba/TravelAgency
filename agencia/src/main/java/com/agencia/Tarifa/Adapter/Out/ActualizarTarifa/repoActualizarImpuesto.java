package com.agencia.Tarifa.Adapter.Out.ActualizarTarifa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Tarifa.Utilities.imprimirDatosTarifa;
import com.mysql.cj.jdbc.CallableStatement;

public class repoActualizarImpuesto {


    public void ejecutarActualizarImpuesto (String numeroTarifa , String nuevoImpuesto , Empleado empleado){

        Scanner sc = new Scanner(System.in);
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

/*         if (nuevaDescripcion.length() > 50) {
            System.out.println("La longitud de la descripción excede el rango (50)");
            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainTarifa.main(null);
        } */

        try {
            
           Connection connection =  DataBaseConfig.DBconnection;
           imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa(); 

           String sql = "{call actualizarImpuestoTarifa (? , ?)}";
           stmt = (CallableStatement) connection.prepareCall(sql);
       
           stmt.setInt(1, Integer.valueOf(numeroTarifa));
           stmt.setDouble(2, Double.valueOf(nuevoImpuesto));

           boolean hasResult = stmt.execute();

           if (!hasResult) {

            System.out.println("No se encontró ninguna tarifa con el ID ingresado.");
/*             System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainTarifa.main(empleado);  */
        
            } else {
                ResultSet rs = stmt.getResultSet();
                imprimirDatosTarifa.imprimir(rs);
                System.out.println("TARIFA ACTUALIZADA CORRECTAMENTE");
/*                 System.out.println("Presiona enter para volver al menu");
                sc.nextLine();
                MainTarifa.main(empleado); */ 
            }

           /* if (hasResult) {

            ResultSet rs = stmt.getResultSet();

            if (rs.next()) {
                // Si hay resultado, imprimir los datos de la tarifa
                imprimirDatosTarifa.imprimir(rs);
                System.out.println("TARIFA ACTUALIZADA CORRECTAMENTE");
                System.out.println("Presiona enter para volver al menu");
                sc.nextLine();
                MainTarifa.main(null);
            } else {
                // Si no hay resultados, imprimir el mensaje de error
                System.out.println("No se encontró ninguna tarifa con el ID ingresado.");
                System.out.println("Presiona enter para volver al menu");
                sc.nextLine();
                MainTarifa.main(null);
            }
            
            } else {
                System.out.println("Error al encontrar la tarifa");
            } */


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
            if (mensaString.contains("impuesto")) {
                System.out.println("Error con el impuesto ingresado ");
            }

            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            
            
        
        }catch (Exception e) {
            System.err.println("Error con los datos ingresados.");
            
        } finally {
            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainTarifa.main(empleado); 
        }
        
    }

}
