package com.agencia.RevisionMantenimiento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Utilities.imprimirHistorialRevision;
import com.mysql.cj.jdbc.CallableStatement;

public class repoConsultarHistorial {

    public void ejecutarConsultarDatos (String placa) {

        CallableStatement stmt = null;
        DataBaseConfig.getConnection();
        Scanner sc = new Scanner(System.in);

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call consultarHistorialRevision (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, placa);
 
        
            System.out.println("Buscando historial de revisiones del avion..." + placa);
            

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al buscar el cliento o no existe");

                } else {
                    
                    ResultSet rs = stmt.getResultSet();

                    imprimirHistorialRevision imprimir = new imprimirHistorialRevision(); 
                    imprimir.imprimir(rs); 

                    System.out.println("\n Proceso Terminado");
                    System.out.println("Presiona enter para volver al menu");
                    sc.nextLine();
                    MainRevisionMantenimiento.main();
                    
                    
                }
            
                
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("TipoDocumento_id")) {
                    System.out.println("Error el tipo de documento es invalido");
                }
            }
        
           
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al consultar el historial . ");
            System.out.println("Presiona enter para volver al menu");
            sc.nextLine();
            MainRevisionMantenimiento.main();
        }




    }

}
