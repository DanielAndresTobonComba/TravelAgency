package com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

import com.agencia.Cliente.Utilities.imprimirDatosCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.mysql.cj.jdbc.CallableStatement;

public class RepoUsuario {

    
    public void actualizarNombreUsuario (String numeroDocumento , String nuevoUsuario) {

            
            CallableStatement stmt = null;
            DataBaseConfig.getConnection();

            try {
            Connection connection = DataBaseConfig.DBconnection;
            
            String sql = "{call actualizarUsuarioCliente (?,?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, numeroDocumento);
            stmt.setString(2, nuevoUsuario);
 
        
            System.out.println("Buscando cliente con el documento..." + numeroDocumento);

            try {

                boolean hasResult = stmt.execute();
        
                if (!hasResult) {
    
                    System.out.println("Error al actualizar el usuario del cliente");

                } else {
                    ResultSet rs = stmt.getResultSet();
                    imprimirDatosCliente imprimirTablaCliente = new imprimirDatosCliente(); 
                    imprimirTablaCliente.imprimir(rs);
                }
            
                stmt.close();
                
            } catch (SQLIntegrityConstraintViolationException b) {
                String mensaString = b.getMessage();

                if (mensaString.contains("usuario")) {
                    System.out.println("Error con el nuevo usuario ingresado");
                }
            }
        
           
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }


}
