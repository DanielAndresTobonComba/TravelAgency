package com.agencia.TipoDocumento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.ImprimirTablaTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazEliminarTipoDocumento;
import com.agencia.TipoDocumento.Main.MainTipoDocumento;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class repoEliminarTipoDocumento implements interfazEliminarTipoDocumento {

    @Override
    public void eliminarTipoDocumento(int numero , Empleado empleado) {



        CallableStatement stmtBuscar = null;
        CallableStatement stmtEliminar = null;
        Connection connection = null;
        connection = DataBaseConfig.DBconnection;

        try {
            connection = DataBaseConfig.DBconnection;

            // Primero buscamos el tipo de documento para imprimirlo
            String sqlBuscar = "{call imprimirTablaConEntradaTipoDocumento (?)}";
            stmtBuscar = (CallableStatement) connection.prepareCall(sqlBuscar);
            stmtBuscar.setInt(1, numero);

            System.out.println("Buscando tipo de documento con la ID " + numero + "...");
            boolean hasResult = stmtBuscar.execute();

            if (hasResult) {
                
                    ResultSet rs = stmtBuscar.getResultSet();
                    ImprimirTablaTipoDocumento imprimirTabla = new ImprimirTablaTipoDocumento(); 
                    imprimirTabla.imprimir(rs);

            } else {
                System.out.println("No se encontró ningún tipo de documento con la ID " + numero);
                return; // Terminamos la ejecución si no hay resultados
            }

            // Luego procedemos a eliminar el tipo de documento
            String sqlEliminar = "{call eliminarTipoDocumento (?)}";
            stmtEliminar = (CallableStatement) connection.prepareCall(sqlEliminar);
            stmtEliminar.setInt(1, numero);

            System.out.println("Ejecutando el procedimiento almacenado para eliminar tipo de documento...");
            hasResult = stmtEliminar.execute();

            if (!hasResult) {
                System.out.println("Tipo de documento eliminado exitosamente");
            } else {
                System.out.println("Error al eliminar el tipo de documento");
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Error de integridad al eliminar el tipo de documento: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error SQL: " + e.getMessage());
        } finally {
            MainTipoDocumento.main(empleado);

            // Cerramos todos los recursos en el bloque finally para asegurar que se liberen correctamente
            /* try {
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
    }

}
