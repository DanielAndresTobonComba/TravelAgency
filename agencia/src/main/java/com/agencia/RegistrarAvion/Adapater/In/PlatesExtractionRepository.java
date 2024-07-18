package com.agencia.RegistrarAvion.Adapater.In;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.RegistrarAvion.Domain.Services.PlatesExtractionService;

import java.sql.CallableStatement;
import java.sql.ResultSet;

public class PlatesExtractionRepository implements PlatesExtractionService {

    @Override
    public List<String> extractPlates() {

        List<String> listExistentPlates = new ArrayList<>();
        ResultSet procedureResulSet = null;
        
        try {

            String sqlProcedure = "{CALL ObtainPlacas()}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.execute();
            procedureResulSet = cs.getResultSet();

            while (procedureResulSet.next()) {
                String plate = procedureResulSet.getString("placa");
                listExistentPlates.add(plate);
                
            }


        } catch (SQLException e) {

            e.printStackTrace();
        }
        return listExistentPlates;
    }



}
