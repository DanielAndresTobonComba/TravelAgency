package com.agencia.ActualizarAvion.Adapter.Out;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.ActualizarAvion.Domain.Service.UpdateAirplaneService;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RegistrarAvion.Domain.Entity.Airplane;

public class MySQLAirplaneUpdateStatusRepository  implements UpdateAirplaneService{

    @Override
    public boolean updateInfo(Airplane airplane) {

        ResultSet resultSet = null;
        int estadoNuevo = airplane.getEstado_id();
        String placa = airplane.getPlaca();
        String hora_before = "";
        String hora_after = "";
        boolean verifyDelete = true;

        try {
                String sqlProcedure = "{CALL ActualizarEstadoAvion(?, ?)}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(sqlProcedure);
                cs.setString(1, placa);
                cs.setInt(2, estadoNuevo);

                cs.execute();

                resultSet = cs.getResultSet();


                while (resultSet.next()) {

                    hora_before = resultSet.getString("TIME_BEFORE");
                    hora_after = resultSet.getString("TIME_AFTER");
    
                    
                }

                if (hora_after.equals(hora_before)) {

                    verifyDelete = false;
    
                }

                
            
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return verifyDelete;


        
    }

}
