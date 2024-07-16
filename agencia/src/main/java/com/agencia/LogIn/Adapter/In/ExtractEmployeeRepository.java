package com.agencia.LogIn.Adapter.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.LogIn.Domain.VerifyEmployeeService;

public class ExtractEmployeeRepository implements VerifyEmployeeService {

    @Override
    public ResultSet extractEmployee (String rol, String usuario) {
        ResultSet procedureObtainEmployee = null;

        try {

            String sqlProcedure = "{CALL ObtainEmpleado(?, ?)}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.setString(1, usuario);
            cs.setString(2, rol);
            cs.execute();
            procedureObtainEmployee= cs.getResultSet();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return procedureObtainEmployee;

        

    }

}