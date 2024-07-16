package com.agencia.LogIn.Adapter.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.LogIn.Domain.ViewRolService;

public class ViewRolsRepository implements ViewRolService {

    @Override
    public List<String> extractRols() {
        List<String> rols = new ArrayList<>();

        try {

            String sqlProcedure = "{CALL ObtainRol()}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.execute();
            ResultSet procedureSet= cs.getResultSet();
            while (procedureSet.next()) {
                rols.add(procedureSet.getString("nombre"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rols;
    }

}
