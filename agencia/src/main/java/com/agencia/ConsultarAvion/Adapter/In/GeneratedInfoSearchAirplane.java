package com.agencia.ConsultarAvion.Adapter.In;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.ConsultarAvion.Domain.Service.ViewSearchAirplaneService;

public class GeneratedInfoSearchAirplane implements ViewSearchAirplaneService {

    @Override
    public void view(ResultSet resultSet) {

        int countRows = 0;
        int id = 0;
        String placa = "";
        int capacidad = 0;
        String fechaFabricacion = "";
        String modelo = "";
        String fabricante = "";
        String estado = "";

        try {

            while(resultSet.next()) {
                countRows ++;
                id = resultSet.getInt("id");
                placa = resultSet.getString("placa");
                capacidad = resultSet.getInt("capacidad");
                fechaFabricacion = resultSet.getString("fechaFabricacion");
                modelo  = resultSet.getString("modelo");
                fabricante = resultSet.getString("fabricante");
                estado = resultSet.getString("estado");
            }

            if (countRows == 1) {

                System.out.println("\n\n==========================================");
                System.out.println("||        INFORMACIÓN DEL AVIÓN         ||");
                System.out.println("||--------------------------------------||");
                System.out.println("||  id:    " + id + "\t\t\t\t||" );
                System.out.println("||  placa:   " + placa + "\t\t\t||");
                System.out.println("||  capacidad:   " + capacidad + "\t\t\t||");
                System.out.println("||  fecha de Fabricación:   " + fechaFabricacion + "\t||");
                if (modelo.length() <=8) {
                    System.out.println("||  modelo:   " + modelo + "\t\t\t||");

                }else {
                    System.out.println("||  modelo:   " + modelo + "\t\t||");
                }
                System.out.println("||  fabricante:   " + fabricante + "\t\t||");
                System.out.println("||  estado:   " + estado + "\t\t\t||");
                System.out.println("==========================================\n");

            } else {

                System.out.println("***********************************************");
                System.out.println("  IMPOSIBLE MOSTRAR INFORMACIÓN DE ESTE AVIÓN");
                System.out.println("***********************************************");

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        
        

        
    }

}
