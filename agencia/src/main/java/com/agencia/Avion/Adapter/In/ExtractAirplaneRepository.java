package com.agencia.Avion.Adapter.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.Avion.Domain.Entity.Airplane;
import com.agencia.Avion.Domain.Service.ExtractAirplaneService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractAirplaneRepository implements ExtractAirplaneService {

    @Override
    public Airplane extractAirplane(String placa) {

        int id = 0;
        int capacidad = 0;
        String fechaFabricacion = "";
        int modelo_id = 0;
        int estado_id = 0;
        Airplane airplane = null;


        try {
                String SQLpricedure = "{CALL ExtractAirplane(?)}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLpricedure);

                cs.setString(1, placa);

                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                while (resultSet.next()) {
                    id = resultSet.getInt("id");
                    capacidad = resultSet.getInt("capacidad");
                    fechaFabricacion = resultSet.getString("fechaFabricacion");
                    modelo_id = resultSet.getInt("ModeloAvion_id");
                    estado_id = resultSet.getInt("Estado_id");

                    
                }

                airplane = new Airplane(id, placa, capacidad, fechaFabricacion, modelo_id, estado_id);

                



        } catch (SQLException e) {

            e.printStackTrace();
        }
        
        return airplane;
    }



}
