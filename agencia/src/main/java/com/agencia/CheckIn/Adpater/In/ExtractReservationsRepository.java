package com.agencia.CheckIn.Adpater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractReservationsService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractReservationsRepository implements ExtractReservationsService{

    @Override
    public List<Integer> extractCodes() {
        
        List<Integer> listRservationsCodes = new ArrayList<>();

        try {
                String SQLprocedure = "{CALL ExtraerReservaciones()}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLprocedure);
                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                while (resultSet.next()) {

                    int code = resultSet.getInt("id");
                    listRservationsCodes.add(code);
            }



        } catch (SQLException e) {

            e.printStackTrace();

        }

        return listRservationsCodes;
    }

    

}
