package com.agencia.CheckIn.Adpater.Out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.CheckIn.Domain.Service.VerifyCheckInService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class VerifyCheckRepository implements VerifyCheckInService {

    @Override
    public int verifyCheckIn(int connectionFlightId, int reservationId) {

        int  insertedRows = 0;

        try {

            String sqlProcedure = "{CALL VerificarCheckIn(?, ?)}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.setInt(1, connectionFlightId);
            cs.setInt(2, reservationId);
            cs.execute();

            ResultSet resulSet = cs.getResultSet();

            while (resulSet.next()) {

                insertedRows = Integer.valueOf(resulSet.getString("rowCounts"));

                
            }

            


        } catch (SQLException e) {

            e.printStackTrace();

        }

        
        return insertedRows;
    }

    

}
