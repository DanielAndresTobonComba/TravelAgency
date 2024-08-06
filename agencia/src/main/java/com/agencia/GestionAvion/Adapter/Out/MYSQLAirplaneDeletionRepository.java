package com.agencia.GestionAvion.Adapter.Out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.GestionAvion.Domain.Service.AirplaneDeleteService;

public class MYSQLAirplaneDeletionRepository implements AirplaneDeleteService {

    @Override
    public boolean delete(String placa) {

        boolean verifyDelete = true;
        String hora_before = "";
        String hora_after = "";

        try {
            String sqlProcedure = "{CALL EliminarAvion(?)}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.setString(1, placa);
            cs.execute();

            ResultSet resulSet = cs.getResultSet();

            while (resulSet.next()) {

                hora_before = resulSet.getString("TIME_BEFORE");
                hora_after = resulSet.getString("TIME_AFTER");

                
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
