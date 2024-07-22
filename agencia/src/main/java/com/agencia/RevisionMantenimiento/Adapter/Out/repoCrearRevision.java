package com.agencia.RevisionMantenimiento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.SQLException;
import java.sql.Date;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Domain.revision;
import com.agencia.RevisionMantenimiento.Utilities.imprimirTablaDatosRevision;
import com.mysql.cj.jdbc.CallableStatement;
import java.util.Scanner;

public class repoCrearRevision {

    public void ejecutarCrearRevision(revision revision) {

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
            stmt.setString(1, revision.getPlacaAvion());
            rs = stmt.executeQuery();
            

            // Aqui es toma el resultado de execute query , is hay algo que es el rs.next() entonces tomara lo que este en la columna IdAvion y se lo dara a idAvion

            int idAvion = -1;
            if (rs.next()) {
                idAvion = rs.getInt("IdAvion");
            }

            if (idAvion == -1) {
                System.out.println("Avión no encontrado.");
                System.out.println("Presiona enter para volver al menú");
                sc.nextLine();
                MainRevisionMantenimiento.main(null);
            } 

            // Crear la revisión
            sql = "{call crearRevision(?, ?, ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
            
            // Convertir java.util.Date a java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(revision.getFecha().getTime());
            stmt.setDate(1, sqlDate);
            stmt.setString(2, revision.getDescripcion());
            stmt.setInt(3, idAvion);

            System.out.println("Ejecutando el procedimiento para crear la revisión...");

            boolean hasResult = stmt.execute();

            if (!hasResult) {
                System.out.println("Error al crear la revisión");
            } else {

                imprimirTablaDatosRevision imprimirDatosRevision = new imprimirTablaDatosRevision();
                rs = stmt.getResultSet();
                imprimirDatosRevision.imprimir(rs);

                System.out.println("Revisión creada exitosamente");

                System.out.println("Presiona enter para volver al menú");
                sc.nextLine();
                MainRevisionMantenimiento.main(null);
            }

        } catch (SQLIntegrityConstraintViolationException b) {
            String message = b.getMessage();

            if (message.contains("TipoDocumento_id")) {
                System.out.println("Error: el tipo de documento es inválido");
            }

            System.out.println("Error con los datos ingresados");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
