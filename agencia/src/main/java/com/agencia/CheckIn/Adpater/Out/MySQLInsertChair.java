package com.agencia.CheckIn.Adpater.Out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.CheckIn.Domain.Service.TakeChairService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class MySQLInsertChair implements TakeChairService {

    @Override
    public int takeChair(String chair, int connectionFlightId, int reservationId) {

        int  insertedRows = 0;

        try {

            String sqlProcedure = "{CALL AsignarAsiento(?, ?, ?)}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.setString(1, chair);
            cs.setInt(2, connectionFlightId);
            cs.setInt(3, reservationId);
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
