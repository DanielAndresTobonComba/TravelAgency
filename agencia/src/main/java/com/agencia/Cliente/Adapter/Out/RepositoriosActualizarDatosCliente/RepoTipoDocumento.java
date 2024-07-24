package com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.Cliente.MainCliente;
import com.agencia.Cliente.Adapter.Out.imprimirTablaTipoDocumento;
import com.agencia.Cliente.Utilities.imprimirDatosCliente;
import com.agencia.Cliente.Utilities.imprimirEnPlacaCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.mysql.cj.jdbc.CallableStatement;

public class RepoTipoDocumento {

  
    public void actualizarTipoDocumento ( String numeroDocumento , String tipoDocumento) {

        Scanner sc = new Scanner(System.in);
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarTipoDocumentoCliente (?,?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
            stmt.setInt(2, Integer.valueOf(tipoDocumento) );
 
        
            System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al actualizar el numero de documento");

                } else {
                    
                    ResultSet rs = stmt.getResultSet(); 

                    imprimirEnPlacaCliente imprimir = new imprimirEnPlacaCliente(); 
                    imprimir.imprimir(rs);
                }
            
                
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("numeroDocumento")) {
                    System.out.println("Error con el numero de documento ingresado");
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
