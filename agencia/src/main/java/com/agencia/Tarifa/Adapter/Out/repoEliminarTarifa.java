package com.agencia.Tarifa.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Application.Casos.eliminarTarifa;
import com.agencia.Tarifa.Application.Service.InterfazEliminaTarifa;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Tarifa.Utilities.imprimirDatosTarifa;
import com.mysql.cj.jdbc.CallableStatement;

public class repoEliminarTarifa implements InterfazEliminaTarifa {

    @Override
    public void eliminar(int numeroTarifa) {
      
        Scanner sc = new Scanner(System.in);
        CallableStatement stmtBuscar = null;
        CallableStatement stmtEliminar = null;
        DataBaseConfig.getConnection();
        

        try {
            Connection connection = DataBaseConfig.DBconnection;


            String sqlBuscar = "{call buscarTarifa (?)}";
            stmtBuscar = (CallableStatement) connection.prepareCall(sqlBuscar);
            stmtBuscar.setInt(1, numeroTarifa);

            System.out.println("Buscando tarifa con la id " + numeroTarifa + "...");

            try {
                boolean hasResult = stmtBuscar.execute();

                if (!hasResult) {

                System.out.println("Error al encontrar la tarifa");

            
                } else {

                    ResultSet rs = stmtBuscar.getResultSet();
                    imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa(); 
                    imprimirDatosTarifa.imprimir(rs);
    
                }

                // Luego procedemos a eliminar el tipo de documento
                String sqlEliminar = "{call eliminarTarifa (?)}";
                stmtEliminar = (CallableStatement) connection.prepareCall(sqlEliminar);
                stmtEliminar.setInt(1, numeroTarifa);

                System.out.println("Ejecutando el procedimiento para eliminar la tarifa...");
                hasResult = stmtEliminar.execute();

                if (hasResult) {
                    System.out.println("Tarifa eliminada exitosamente");
                } else {
                    System.out.println("Error al eliminar el tipo de documento");
                }

                
            } catch (Exception e) {
                // TODO: handle exception
            }

            


            

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error de integridad al eliminar la tarifa: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } 



    }

    

}
