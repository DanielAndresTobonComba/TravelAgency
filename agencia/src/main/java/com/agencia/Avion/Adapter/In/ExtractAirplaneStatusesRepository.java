package com.agencia.Avion.Adapter.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.Avion.Domain.Service.ExtractRegistersService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractAirplaneStatusesRepository implements  ExtractRegistersService{

    @Override
    public ResultSet extractInfo() {
        
        ResultSet procedureResulSet = null;
        
        try {

            String sqlProcedure = "{CALL ObtainEstadoAvion()}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.execute();
            procedureResulSet = cs.getResultSet();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return procedureResulSet;
    }

}
