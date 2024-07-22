package com.agencia.RevisionMantenimiento.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.AbstractClasses.imprimirTabla;

public class imprimirExisteAvion extends imprimirTabla {

    @Override
    public void imprimir(ResultSet rs) throws SQLException {

        System.out.println("\nAVION ENCONTRADO");

        System.out.println("+------------------------------+------------+");
        System.out.printf("| %-10s | %-15s | %-10s |\n", 
            "Placa", "Modelo" , "idAvion");
        System.out.println("+------------------------------+------------+");

        while (rs.next()) {
            String placa = rs.getString("Placa");
            String modelo = rs.getString("Modelo");
            int id = rs.getInt("IdAvion");

            System.out.printf("| %-10s | %-15s | %-10d |\n", 
                placa, modelo , id);
        }

        System.out.println("+-------------------------------+-----------+");
    }

}
