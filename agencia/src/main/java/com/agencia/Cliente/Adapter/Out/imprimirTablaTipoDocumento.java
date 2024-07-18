package com.agencia.Cliente.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.mysql.cj.jdbc.CallableStatement;

public class imprimirTablaTipoDocumento {

    public static void imprimirTablaTipoDoc () {

        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "Select id , nombre from TipoDocumento";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            System.out.println("Buscando cliente con el documento...");

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
                    System.out.println("Error al actualizar el numero de documento");
                } else {
                    ResultSet rs = stmt.getResultSet();

                    System.out.println("\nTablas tipo doc");
                    System.out.println("+--------+--------------------------------------------------+");
                    System.out.printf("| %-6s | %-50s |\n", "ID", "Tipo Documento");
                    System.out.println("+--------+--------------------------------------------------+");

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String tipoDoc = rs.getString("nombre");

                        System.out.printf("| %-6d | %-50s |\n", id, tipoDoc);
                    }

                    System.out.println("+--------+--------------------------------------------------+");
                }
            
                stmt.close();
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("numeroDocumento")) {
                    System.out.println("Error con el numero de documento ingresado");
                }
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
