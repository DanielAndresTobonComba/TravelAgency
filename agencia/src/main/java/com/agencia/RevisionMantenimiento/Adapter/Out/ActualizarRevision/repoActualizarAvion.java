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

public class repoActualizarAvion {

    public void ejecutarActualizarAvion (String numeroRevision , String placaAvion) {


        Scanner sc = new Scanner(System.in);
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();
        String sql;
        ResultSet rs = null;

        try {
            Connection connection = DataBaseConfig.DBconnection;

            // Consultar el avión
            sql = "{call consultarAvion(?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
            stmt.setString(1, placaAvion);
            rs = stmt.executeQuery();
            

            // Aqui es toma el resultado de execute query , is hay algo que es el rs.next() entonces tomara lo que este en la columna IdAvion y se lo dara a idAvion

            int idAvion = -1;
            if (rs.next()) {
                idAvion = rs.getInt("AvionId");
            }

            if (idAvion == -1) {
                System.out.println("Avión no encontrado.");
                System.out.println("Presiona enter para volver al menú");
                sc.nextLine();
                MainRevisionMantenimiento.main();
            } 

            // Crear la revisión
            sql = "{call actualizarAvionRevision(?, ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);

            stmt.setInt(1, Integer.valueOf(numeroRevision) );
            stmt.setInt(2 , idAvion);

            System.out.println("Ejecutando el procedimiento para actualizar el avion de la revisión...");

            boolean hasResult = stmt.execute();

            if (!hasResult) {
                System.out.println("Error al actualizar el avion");
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
