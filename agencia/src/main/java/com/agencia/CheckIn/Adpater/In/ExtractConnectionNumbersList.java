package com.agencia.CheckIn.Adpater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractConnectionNumbersService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractConnectionNumbersList implements ExtractConnectionNumbersService {

    @Override
    public List<String> extractConnections(int Viaje_id) {
        List<String> listConnectionNumbers = new ArrayList<>();

        try {

                String SQLprocedure = "{CALL TraerVuelosConexion(?)}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLprocedure);
                cs.setInt(1, Viaje_id);
                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                while (resultSet.next()) {

                    String connectionNumber = resultSet.getString("numeroConexion");
                    listConnectionNumbers.add(connectionNumber);

                }

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return listConnectionNumbers;
    }

}
