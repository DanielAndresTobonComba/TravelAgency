package com.agencia.CheckIn.Adpater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.CheckIn.Domain.Entity.ConnectionFlight;
import com.agencia.CheckIn.Domain.Entity.Reservation;
import com.agencia.CheckIn.Domain.Service.ExtractInfoConnFlightService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractConnFlightEntity  implements ExtractInfoConnFlightService{

    @Override
    public ConnectionFlight extractEntity(String connectionNumber) {

        ConnectionFlight connectionFlight = null;
        int id = 0;
        int idAeropuertoOrigen = 0;
        int idAeropuertoDestino = 0;
        int Viaje_id = 0;
        int Avion_id = 0;

        try {

                String SQLprocedure = "{CALL ExtraerVueloConexion(?)}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLprocedure);
                cs.setString(1, connectionNumber);
                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                while (resultSet.next()) {

                    id = resultSet.getInt("id");
                    idAeropuertoOrigen = resultSet.getInt("idAeropuertoOrigen");
                    Viaje_id = resultSet.getInt("Viaje_id");
                    Avion_id = resultSet.getInt("Avion_id"); 
                    idAeropuertoDestino = resultSet.getInt("idAeropuertoDestino");

                    connectionFlight = new ConnectionFlight(id, connectionNumber, idAeropuertoOrigen,  Viaje_id, Avion_id, idAeropuertoDestino);
                    

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }
        
        return connectionFlight;
    }

    

}
