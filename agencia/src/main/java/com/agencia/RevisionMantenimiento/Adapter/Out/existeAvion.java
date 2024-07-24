package com.agencia.RevisionMantenimiento.Adapter.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.agencia.AbstractClasses.verificarExistencia;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RevisionMantenimiento.Utilities.imprimirExisteAvion;
import com.mysql.cj.jdbc.CallableStatement;

public class existeAvion extends verificarExistencia {

    @Override
    public boolean verficiar(String id) {

        // Scanner sc = new Scanner(System.in);

        
        CallableStatement stmt = null;
        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;

            System.out.println("Buscando avion con la placa..." + id);
            
            String sql = "{call consultarAvionDaniel (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);
        
            stmt.setString(1, id );

            boolean hasResult = stmt.execute();

            if (!hasResult) {
                System.out.println("Error al buscar el avion o no existe");
                return false;
            } else {

                try (ResultSet rs = stmt.getResultSet()) {
                    if (!rs.isBeforeFirst()) {
                        System.out.println("Avion no encontrado en la base de datos");
                        return false;
                    }
                    
                    imprimirExisteAvion imprimirExisteAvion = new imprimirExisteAvion(); 
                    imprimirExisteAvion.imprimir(rs);
                    return true;
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
        
    }

}
