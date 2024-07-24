package com.agencia.CheckIn.Adpater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractReservedChairsService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractReservedChairsList implements ExtractReservedChairsService{

    @Override
    public List<String> extractChairs(String connectionFlight) {
        
        List<String> listReservedChairs = new ArrayList<>();

        try {

                String SQLprocedure = "{CALL ExtraerAsientos(?)}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLprocedure);
                cs.setString(1, connectionFlight);
                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                while (resultSet.next()) {

                    String chair = resultSet.getString("asiento");
                    listReservedChairs.add(chair);

                }


        } catch (SQLException e) {

            e.printStackTrace();

        }


        return listReservedChairs;
    }

}
