package com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.Cliente.MainCliente;
import com.agencia.Cliente.Utilities.imprimirEnPlacaCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class RepoNombre {


    public void actualizarNombre (String nuevoNombre , String numeroDocumento) {

        Scanner sc = new Scanner(System.in);


        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarNombreCliente (? , ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
            stmt.setString(2, nuevoNombre);
 
        
            //  System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al buscar el cliento o no existe");

                } else {
                    ResultSet rs = stmt.getResultSet(); 

                    imprimirEnPlacaCliente imprimir = new imprimirEnPlacaCliente(); 
                    imprimir.imprimir(rs);
                    
                }
            
                
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("TipoDocumento_id")) {
                    System.out.println("Error el tipo de documento es invalido");
                }
            }
        
           
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            System.out.println("Proceso finalizado ");
            System.out.println("Presiona enter para volver al menu");
            sc.nextLine(); 
            MainCliente.main(null);
        }
        


    }


}


