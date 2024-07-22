package com.agencia.RevisionMantenimiento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Utilities.imprimirTablaDatosRevision;
import com.mysql.cj.jdbc.CallableStatement;

public class repoEliminarRevision {

    public void ejecutarEliminarRevision (int numero) {

        
        CallableStatement stmtEliminar = null;
        Connection connection = null;
        connection = DataBaseConfig.DBconnection;
        boolean hasResult = true ;
        Scanner sc = new Scanner(System.in);

        existeRevision existeRevision = new existeRevision(); 


        if (existeRevision.verficiar(String.valueOf(numero))) {

            try {
                String sqlEliminar = "{call eliminarRevision (?)}";
    
                stmtEliminar = (CallableStatement) connection.prepareCall(sqlEliminar);
                stmtEliminar.setInt(1, numero);
    
                System.out.println("Ejecutando el procedimiento para eliminar la revisiòn");
                hasResult = stmtEliminar.execute();
    
                if (!hasResult) {
                    System.out.println("Revision eliminada exitosamente");
                } else {
                    System.out.println("Error al eliminar el tipo de documento");
                }
    
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Error de integridad al eliminar la revision: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Error SQL: " + e.getMessage());
            } finally {
                System.out.println("Proceso finalizado");
                System.out.println("Presiona enter para volver al menu");
                sc.nextLine();
                MainRevisionMantenimiento.main();
    
                // Cerramos todos los recursos en el bloque finally para asegurar que se liberen correctamente
    /*             try {
                    if (stmtBuscar != null) {
                        stmtBuscar.close();
                    }
                    if (stmtEliminar != null) {
                        stmtEliminar.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } */
            }

        } else {
            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainRevisionMantenimiento.main();
        }

        
    }

}
