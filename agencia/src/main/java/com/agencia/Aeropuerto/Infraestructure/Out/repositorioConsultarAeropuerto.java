package com.agencia.Aeropuerto.Infraestructure.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.Aeropuerto.Domain.Service.interfazConsultarAeropuerto;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.mysql.cj.jdbc.CallableStatement;

public class repositorioConsultarAeropuerto implements interfazConsultarAeropuerto {

    @Override
    public void consultarAeropuerto(String numeroAeropuerto) {

        CallableStatement stmt = null;
       

        DataBaseConfig.getConnection();

        try (Connection connection = DataBaseConfig.DBconnection;) {

            String sql = "{call consultarAeropuerto  (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);

            stmt.setString(1, numeroAeropuerto);

            System.out.println("Ejecutando el procedimiento almacenado para consultar datos del aeropuerto...");

            // Creo un boleano para saber si la ejecuacion del procedimiento fue exitosa
            boolean hasResult = stmt.execute();

            // Si fue exitosa obtenfo los resultados que me bota el procedimeinto en el select * que tengo antes del delete y los imprimo
            if (hasResult) {
                try (ResultSet rs = stmt.getResultSet()) {

                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+");
                        System.out.printf("| %-45s | %-10s | %-25s |\n", "Nombre", "Ciudad ID", "Número de Aeropuerto");
                        System.out.println("+-------------------------------+----------+-------------------+-------------------+-------------------+");
                        
                        while (rs.next()) {
                            // Obtener y mostrar los datos del aeropuerto
                            //int id = rs.getInt("id");
                            String nombre = rs.getString("nombre");
                            int ciudadId = rs.getInt("Ciudad_id");
                            String numero = rs.getString("numeroAeropuerto");

                            System.out.printf("| %-45s | %-10d | %-25s |\n", nombre, ciudadId, numero);
                        }
                }
            } 

           

            stmt.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\n\nError al consultar el aeropuerto con ID: " + numeroAeropuerto);
            System.out.println("Error de sistema: " + e);
            // Aquí se debería manejar de forma más adecuada, dependiendo del contexto de tu aplicación
        }
        
    }
        
}


