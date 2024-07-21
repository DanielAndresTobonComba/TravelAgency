package com.agencia.ConsultarAvion.Adapter.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.ConsultarAvion.Domain.Service.SearchAirplaneService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class MYSQLAirplaneSearchRepository implements SearchAirplaneService {

   @Override
   public ResultSet search(String placa) {

    ResultSet resultSet = null;

    try {
            String sqlProcedure = "{CALL ConsultarAvion(?)}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.setString(1, placa);
            cs.execute();

            resultSet = cs.getResultSet();


        } catch (SQLException e) {

            e.printStackTrace();

        }

    return resultSet;

   } 

}
