package com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.Cliente.Utilities.imprimirDatosCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Verifiers.PasswordEncripted;
import com.mysql.cj.jdbc.CallableStatement;

public class RepoContrasena {

    public void actualizarContraseña (String numeroDocumento , String contraseña) {
        

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
                    imprimirDatosCliente imprimirTablaCliente = new imprimirDatosCliente(); 
                    imprimirTablaCliente.imprimir(rs);
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
        }
    }

}
