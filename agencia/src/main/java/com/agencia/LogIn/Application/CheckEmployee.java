package com.agencia.LogIn.Application;

import com.agencia.LogIn.Domain.VerifyEmployeeService;
import java.sql.ResultSet;

public class CheckEmployee {

    private final VerifyEmployeeService verifyEmployeeService;

    public CheckEmployee(VerifyEmployeeService verifyEmployeeService) {
        this.verifyEmployeeService = verifyEmployeeService;
    }

    public ResultSet extract(String rol, String usuario) {
        return verifyEmployeeService.extractEmployee(rol, usuario);
    }

}
