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

public class RepoEdad {


    public void actualizarEdad (String edadNueva , String numeroDocumento) {

        System.out.println("LLEGUE A LA DB CON : " + edadNueva + numeroDocumento);

        Scanner sc = new Scanner(System.in);
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarEdadCliente (? , ?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
            stmt.setString(2, edadNueva);
 
        
            //  System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al buscar el cliente");

                } else {
                    ResultSet rs = stmt.getResultSet(); 

                    imprimirEnPlacaCliente imprimir = new imprimirEnPlacaCliente(); 
                    imprimir.imprimir(rs);


                    System.out.println("Proceso finalizado ");
                    System.out.println("Presiona enter para volver al menu");
                    sc.nextLine(); 
                    MainCliente.main(null);
                }
            
                
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("edad")) {
                    System.out.println("Error la edad es invalida");
                }

                
            } catch (Exception e) {
                System.out.println("ERROR AL MODIFICAR LA EDAD DEL CLIENTE");
                
                e.printStackTrace();
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
