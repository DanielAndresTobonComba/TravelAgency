package com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

import com.agencia.Cliente.MainCliente;
import com.agencia.Cliente.Utilities.imprimirDatosCliente;
import com.agencia.Cliente.Utilities.imprimirEnPlacaCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class RepoContrasena {

    public void actualizarContraseña (String numeroDocumento , String contraseña) {
        
        Scanner sc = new Scanner(System.in);

        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarContraseñaCliente (?,?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
            stmt.setString(2, PasswordEncripted.encript(contraseña) );
 
        
            System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al actualizar la contraseña");

                } else {
                    ResultSet rs = stmt.getResultSet(); 

                    imprimirEnPlacaCliente imprimir = new imprimirEnPlacaCliente(); 
                    imprimir.imprimir(rs);


                    

                }
            
                stmt.close();
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("contraseña")) {
                    System.out.println("Error con la contraseña ingresada");
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
