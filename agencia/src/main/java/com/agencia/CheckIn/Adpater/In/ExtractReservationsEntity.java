package com.agencia.CheckIn.Adpater.In;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.CheckIn.Domain.Entity.Reservation;
import com.agencia.CheckIn.Domain.Service.ExtractInfoReservationsService;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class ExtractReservationsEntity implements ExtractInfoReservationsService {

    @Override
    public Reservation extractEntity(int id) {

        Reservation reservation = null;
        String fecha = "";
        int Viaje_id = 0;
        int Tarifa_id = 0;
        int Cliente_id = 0;
        int MetodoPago_id = 0;
        int estadoPago = 0;
        String nombrePasajero = "";
        int edad = 0;
        String dni = "";
        int TipoDocumento_id = 0;

        try {

                String SQLprocedure = "{CALL ExtraerInfoReservacion(?)}";
                Connection connection = DataBaseConfig.getConnection().DBconnection;
                CallableStatement cs = connection.prepareCall(SQLprocedure);
                cs.setInt(1, id);
                cs.execute();

                ResultSet resultSet = cs.getResultSet();

                while (resultSet.next()) {

                    fecha = resultSet.getString("fecha");
                    Viaje_id = resultSet.getInt("Viaje_id");
                    Tarifa_id = resultSet.getInt("Tarifa_id");
                    Cliente_id = resultSet.getInt("Cliente_id");
                    MetodoPago_id = resultSet.getInt("MetodoPago_id") ;
                    estadoPago = resultSet.getInt("estadoPago");
                    nombrePasajero = resultSet.getString("nombrePasajero");
                    edad = resultSet.getInt("edad");
                    dni = resultSet.getString("dni");
                    TipoDocumento_id = resultSet.getInt("TipoDocumento_id");

                    reservation = new Reservation(id, fecha, Viaje_id, Tarifa_id, Cliente_id, MetodoPago_id, estadoPago, nombrePasajero, edad, dni, TipoDocumento_id);

            }


        } catch (SQLException e) {

            e.printStackTrace();

        }

        
        return reservation;
    }



}
