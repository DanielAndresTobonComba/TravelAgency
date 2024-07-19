package com.agencia.RegistrarAvion.Adapater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RegistrarAvion.Domain.Services.ExtractRegistersService;

public class ExtractAirplaneModelsRepository implements ExtractRegistersService {

    @Override
    public ResultSet extractInfo() {

        ResultSet procedureResulSet = null;
        
        try {

            String sqlProcedure = "{CALL ObtainModeloAvion()}";
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
