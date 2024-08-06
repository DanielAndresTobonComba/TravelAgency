package com.agencia.GestionAvion.Adapter.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.GestionAvion.Domain.Service.SearchAirplaneService;

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
