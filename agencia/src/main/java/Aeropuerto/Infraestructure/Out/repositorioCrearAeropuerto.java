package Aeropuerto.Infraestructure.Out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import com.agencia.DataBaseConfig.DataBaseConfig;

import Aeropuerto.Domain.Entity.Aeropuerto;
import Aeropuerto.Domain.Service.interfazCrearAeropuerto;

public class repositorioCrearAeropuerto implements interfazCrearAeropuerto {

    @Override
    public void crearAeropuerto(Aeropuerto aeropuerto) {

        String sql = "INSERT INTO Aeropuerto (nombre , Ciudad_id , numeroAeropuerto) VALUES (?,?,?)";



        DataBaseConfig.getConnection();
        try (Connection connection = DataBaseConfig.DBconnection;
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS))
        {
            statement.setString(1, aeropuerto.getNombre());
            statement.setInt(2, aeropuerto.getIdCiudad());
            statement.setString(3, aeropuerto.getNumAeropuerto());

            statement.executeUpdate();

            

            System.out.println("Aeropuerto creado exitosamente");
            
        } catch (SQLIntegrityConstraintViolationException  b) {
            String errorMessage = b.getMessage();
            
                if (errorMessage.contains("nombre")) {

                    System.out.println("Error: Ya existe un aeropuerto con ese nombre. ");

                } else if (errorMessage.contains("numeroAeropuerto")) {

                    System.out.println("Error: Ya existe un aeropuerto con ese número de aeropuerto. ");

                } else {
                    System.out.println("Error de restricción de integridad: " + b.getMessage());
                }
        }  
        
        catch (SQLException e) {  
            System.out.println("Error al crear el aeropuerto: " + e);
        }
       
    }

}
