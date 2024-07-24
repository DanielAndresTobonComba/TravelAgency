package com.agencia.CheckIn.Adpater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.CheckIn.Domain.Service.ExtractAirplaneCapacityService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractAirplaneCapacityRepository implements ExtractAirplaneCapacityService {

    @Override
    public int obtainCapacity(int AirplaneId) {
        int capacity = 0;

        try {

                String SQLprocedure = "{CALL CapacidadAvion(?)}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLprocedure);
                cs.setInt(1, AirplaneId);
                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                while (resultSet.next()) {

                    capacity = resultSet.getInt("capacidad");

                }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return capacity;
    }

}
