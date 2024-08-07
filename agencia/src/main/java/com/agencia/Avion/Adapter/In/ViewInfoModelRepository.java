package com.agencia.Avion.Adapter.In;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.agencia.Avion.Domain.Service.ViewInfoService;

public class ViewInfoModelRepository implements ViewInfoService {

    @Override
    public List<Integer> print(ResultSet resultSet) {
        List<Integer> listCodes = new ArrayList<>();
        int rowCount = 0;

        try {

            
            System.out.println("\n\n==========================================");
            System.out.println("           MODELOS REGISTRADOS");
            System.out.println("==========================================");
            System.err.println("  COD\t|    MODELO");
            System.out.println("------------------------------------------");

            while ( resultSet.next()) {

                rowCount++;
                int code = resultSet.getInt("idmodelo");
                listCodes.add(code);
                String model = resultSet.getString("modelo");
                System.out.println("  " + code + ".\t|  " + model);
            
            }

            if (rowCount == 0) {

                System.out.println("\nNO HAY MODELOS REGISTRADOS\n");

            }

            System.out.println("------------------------------------------");

        } catch (SQLException e) {

            e.printStackTrace();
        }

        


        return listCodes;
    }
    

}
