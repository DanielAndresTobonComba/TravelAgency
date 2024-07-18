package com.agencia.AbstractClasses;

import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

public abstract class imprimirTabla {


    public abstract void imprimir (CallableStatement stmt) throws SQLException ;

}
