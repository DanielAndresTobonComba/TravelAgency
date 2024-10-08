package com.agencia.GestionAvion.Adapter.Out;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.GestionAvion.Domain.Entity.Airplane;
import com.agencia.GestionAvion.Domain.Service.AirplaneRecordService;

public class MySQLAirplaneRegistrationRepository implements AirplaneRecordService {

    @Override
    public int record(Airplane airplane){

        
        String placa = airplane.getPlaca();
        int capacidad = airplane.getCapacidad();
        String fechaFabricacion = airplane.getFechaFabricacion();
        int modeloAvionId = airplane.getModeloAvion_id();
        int estadoAvion = airplane.getEstado_id();
        int insertedRows = 0;
        ResultSet procedureInsertarAvion = null;

        try {

            // Ejecuto el procedimiento para insertar el Avion
            String sqlProcedure = "{CALL InsertarAvion(?, ?, ?, ?, ?)}";
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement cs = connection.prepareCall(sqlProcedure);
            cs.setString(1, placa);
            cs.setInt(2, capacidad);
            cs.setString(3, fechaFabricacion);
            cs.setInt(4, modeloAvionId);
            cs.setInt(5, estadoAvion);

            cs.execute();

            // Me traigo el resultado del procedimiento que coinbcide con el número de filas insertadas en Avion
            procedureInsertarAvion= cs.getResultSet();

            // Hago la conversión del resultado del procedimiento a entero
            while (procedureInsertarAvion.next()) {
                insertedRows = Integer.valueOf(procedureInsertarAvion.getString("numRow"));
                
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }        

        return insertedRows;

    }

}
