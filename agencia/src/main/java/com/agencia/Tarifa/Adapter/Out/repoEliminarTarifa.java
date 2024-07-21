package com.agencia.Tarifa.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Tarifa.MainTarifa;
import com.agencia.Tarifa.Application.Casos.eliminarTarifa;
import com.agencia.Tarifa.Application.Service.InterfazEliminaTarifa;
import com.agencia.Tarifa.Utilities.imprimirDatosTarifa;
import com.agencia.TipoDocumento.ImprimirTablaTipoDocumento;
import com.mysql.cj.jdbc.CallableStatement;

public class repoEliminarTarifa implements InterfazEliminaTarifa {

    @Override
    public void eliminar(int numeroTarifa) {
      
        Scanner sc = new Scanner(System.in);
        CallableStatement stmtBuscar = null;
        CallableStatement stmtEliminar = null;
        Connection connection = null;
        connection = DataBaseConfig.DBconnection;

        try {
            connection = DataBaseConfig.DBconnection;

            // Primero buscamos el tipo de documento para imprimirlo
            String sqlBuscar = "{call buscarTarifa (?)}";
            stmtBuscar = (CallableStatement) connection.prepareCall(sqlBuscar);
            stmtBuscar.setInt(1, numeroTarifa);

            System.out.println("Buscando tarifa con la id " + numeroTarifa + "...");

            boolean hasResult = stmtBuscar.execute();

            if (hasResult) {

                ResultSet rs = stmtBuscar.getResultSet();
    
                if (rs.next()) {

                    imprimirDatosTarifa imprimirDatosTarifa = new imprimirDatosTarifa(); 
                    imprimirDatosTarifa.imprimir(rs);

                } else {
                    // Si no hay resultados, imprimir el mensaje de error
                    System.out.println("No se encontró ninguna tarifa con el ID ingresado.");
                    System.out.println("Presiona enter para volver al menu");
                    sc.nextLine();
                    MainTarifa.main(null);
                }
                
                } else {
                    System.out.println("Error al encontrar la tarifa");
                }


            // Luego procedemos a eliminar el tipo de documento
            String sqlEliminar = "{call eliminarTarifa (?)}";
            stmtEliminar = (CallableStatement) connection.prepareCall(sqlEliminar);
            stmtEliminar.setInt(1, numeroTarifa);

            System.out.println("Ejecutando el procedimiento para eliminar la tarifa...");
            hasResult = stmtEliminar.execute();

            if (!hasResult) {
                System.out.println("Tipo de documento eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar el tipo de documento");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error de integridad al eliminar la tarifa: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } finally {

            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainTarifa.main(null);
            
        }



    }

    

}
