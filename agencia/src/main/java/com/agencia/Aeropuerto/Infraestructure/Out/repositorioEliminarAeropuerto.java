package com.agencia.Aeropuerto.Infraestructure.Out;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.lang.String;

import com.agencia.Aeropuerto.Domain.Service.interfazEliminarAeropuerto;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.ResultSet;



public class repositorioEliminarAeropuerto implements interfazEliminarAeropuerto {

    @Override
    public void eliminarAeropuerto(String numeroAeropuerto) {

        CallableStatement stmt = null;
       

        DataBaseConfig.getConnection();

        try {
            Connection connection = DataBaseConfig.DBconnection;

            String sql = "{call eliminarAeropuerto  (?)}";
            stmt = (CallableStatement) connection.prepareCall(sql);

            stmt.setString(1, numeroAeropuerto);

            System.out.println("Ejecutando el procedimiento almacenado  eliminar aeropuerto...");

            // Creo un boleano para saber si la ejecuacion del procedimiento fue exitosa
            boolean hasResult = stmt.execute();

            // Si fue exitosa obtenfo los resultados que me bota el procedimeinto en el select * que tengo antes del delete y los imprimo
            if (hasResult) {
                try (ResultSet rs = stmt.getResultSet()) {

                    System.out.println("\tAEROPUERTO ELIMINADO");
                    
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
            System.out.println("Error al intentar eliminar el aeropuerto con ID: " + numeroAeropuerto);
            System.out.println("Error de sistema: " + e);
            // Aquí se debería manejar de forma más adecuada, dependiendo del contexto de tu aplicación
        }
        
    }


/* USANDO SENTENCIA QUEMASDAS 
    @Override
    public void eliminarAeropuerto(String numeroAeropuerto) {

        java.lang.String sql = "DELETE FROM Aeropuerto WHERE numeroAeropuerto = ?";
        
        DataBaseConfig.getConnection();
        try (Connection connection = DataBaseConfig.DBconnection;
             PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setString(1, numeroAeropuerto);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Aeropuerto eliminado exitosamente con numero: " + numeroAeropuerto);
            } else {
                System.out.println("No se encontró un aeropuerto con el numero: " + numeroAeropuerto);
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el aeropuerto con ID: " + numeroAeropuerto);
            System.out.println("Error de sistema: " + e);
            // Aquí se debería manejar de forma más adecuada, dependiendo del contexto de tu aplicación
        }
       
    } */

    // USANDO PROCEDIMIENTOS 

    



}
