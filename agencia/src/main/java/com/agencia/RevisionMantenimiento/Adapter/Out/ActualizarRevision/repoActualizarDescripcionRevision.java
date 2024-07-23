package com.agencia.RevisionMantenimiento.Adapter.Out.ActualizarRevision;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Utilities.imprimirTablaDatosRevision;
import com.mysql.cj.jdbc.CallableStatement;

public class repoActualizarDescripcionRevision {

    public void ejecutarActualizarDescripcion (String numeroRevision , String descripcion){

        System.out.println("Entre a la db");

        Scanner sc = new Scanner(System.in);
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();
        String sql;
        ResultSet rs = null;

        try {
            Connection connection = DataBaseConfig.DBconnection;

 
            // Crear la revisión
            sql = "{call actualizarDescripcionRevision(?, ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);

            stmt.setInt(1, Integer.valueOf(numeroRevision) );
            stmt.setString(2 , descripcion);

            System.out.println("Ejecutando el procedimiento para actualizar la descripciòn de la  revisión...");

            boolean hasResult = stmt.execute();

            if (!hasResult) {
                System.out.println("Error al actualizar la revisiòn");
            } else {

                imprimirTablaDatosRevision imprimirDatosRevision = new imprimirTablaDatosRevision();
                rs = stmt.getResultSet();
                imprimirDatosRevision.imprimir(rs);

                System.out.println("Revisión actualizada exitosamente");

                System.out.println("Presiona enter para volver al menú");
                sc.nextLine();
                MainRevisionMantenimiento.main();
            }

        } catch (SQLIntegrityConstraintViolationException b) {
            System.out.println("Error con los datos ingresados");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
/*             try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } */
        }

    }

}
