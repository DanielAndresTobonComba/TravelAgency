package com.agencia.RevisionMantenimiento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.agencia.AbstractClasses.verificarExistencia;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Utilities.imprimirDatosRevision;
import com.mysql.cj.jdbc.CallableStatement;

public class existeRevision extends verificarExistencia {

    @Override
    public boolean verficiar(String numero) {

        Scanner sc = new Scanner(System.in);
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;

            String sql = "{call imprimirRevision (?)}";

            stmt = (CallableStatement) connection.prepareCall(sql);

            stmt.setInt(1, Integer.valueOf(numero));

            System.out.println("Buscando revisión con la ID.... " + numero);

            boolean hasResult = stmt.execute();

            if (!hasResult) {
                System.out.println("Error al buscar la revisiòn o no existe");
                return false;
            } else {

                try (ResultSet rs = stmt.getResultSet()) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("Revisiòn no encontrada en la base de datos");
                        return false;
                    } else {
                        imprimirDatosRevision imprimirDatosRevision = new imprimirDatosRevision(); 
                        imprimirDatosRevision.imprimir(rs);
                        return true;
                    }
                    

                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar la revisión: " + e.getMessage());
            return false;
        } finally {
            // Cierre de recursos
/*             try {
                if (stmtBuscar != null) {
                    stmtBuscar.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el CallableStatement: " + e.getMessage());
            } */
        }
    }

}
