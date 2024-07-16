package com.agencia.LogIn.Domain;

import java.sql.ResultSet;

public interface VerifyEmployeeService {

    ResultSet extractEmployee(String rol, String usuario);

}
