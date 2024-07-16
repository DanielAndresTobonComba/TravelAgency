package com.agencia.Aeropuerto.Infraestructure.Out;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.agencia.Aeropuerto.Domain.Service.interfazActualizarAeropuerto;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.SQLIntegrityConstraintViolationException;

public class repositorioActualizarAeropuerto implements interfazActualizarAeropuerto {

    @Override
    public void actualizarAeropuerto(String numeroAeropuerto, int opcion) {

        System.out.println("Entre a la conexion db");

        try  {
            Connection connection = DataBaseConfig.getConnection().DBconnection;
            CallableStatement stmt = null;
            String sql = "";
            boolean hasResult;

            switch (opcion) {

                case 1:
                    System.out.println("Digita el nuevo nombre");
                    String nuevoNombre = CheckString.check("Digita de nuevo el nombre");

                    sql = "{call actualizarNombreAeropuerto(?, ?)}";

                    stmt = (CallableStatement) connection.prepareCall(sql);

                    stmt.setString(1, numeroAeropuerto);
                    stmt.setString(2, nuevoNombre);

                    System.out.println("Ejecutando el procedimiento almacenado para actualizar los datos del aeropuerto...");

                    try {

                        hasResult = stmt.execute();

                        if (hasResult) {
                            try (ResultSet rs = stmt.getResultSet()) {
    
                                System.out.println("+-------------------------------+----------+-------------------+");
                                System.out.printf("| %-29s | %-8s | %-17s |\n", "Nombre", "Ciudad ID", "Número de Aeropuerto");
                                System.out.println("+-------------------------------+----------+-------------------+");
    
                                while (rs.next()) {
                                    String nombre = rs.getString("nombre");
                                    int ciudadId = rs.getInt("Ciudad_id");
                                    String numero = rs.getString("numeroAeropuerto");
    
                                    System.out.printf("| %-29s | %-8d | %-17s |\n", nombre, ciudadId, numero);
                                }
                                System.out.println("+-------------------------------+----------+-------------------+");
    
                            } 
                            
                            catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("\n\nError al actualizar el aeropuerto con ID: " + numeroAeropuerto);
                                System.out.println("Error de sistema: " + e);
                            }
                        } else {
                            System.out.println("El aeropuerto no existe");
                        }
                        
                    }  catch (SQLIntegrityConstraintViolationException b) {
                        String mensaje = b.getMessage();
                        if (mensaje.contains("nombre")) {
                            System.out.println("Error: Ya existe un aeropuerto con ese nombre. ");
                        }
                       
                        
                    }
                    
                    catch (Exception e) {
                        // TODO: handle exception
                    }
                   
                    break;

                case 2:
                    System.out.println("Digita el nuevo codigo de la ciudad");
                    int nuevoIDCiudad = CheckInt.check("Digita de nuevo el codigo");

                    sql = "{call actualizarCiudad(?, ?)}";

                    stmt = (CallableStatement) connection.prepareCall(sql);

                    stmt.setString(1, numeroAeropuerto);
                    stmt.setInt(2, nuevoIDCiudad);

                    System.out.println("Ejecutando el procedimiento almacenado para actualizar los datos del aeropuerto...");

                    
                    try {
                        hasResult = stmt.execute();  

                        if (hasResult) {
                            try (ResultSet rs = stmt.getResultSet()) {
    
                                System.out.println("+-------------------------------+----------+-------------------+");
                                System.out.printf("| %-29s | %-8s | %-17s |\n", "Nombre", "Ciudad ID", "Número de Aeropuerto");
                                System.out.println("+-------------------------------+----------+-------------------+");
    
                                while (rs.next()) {
                                    String nombre = rs.getString("nombre");
                                    int ciudadId = rs.getInt("Ciudad_id");
                                    String numero = rs.getString("numeroAeropuerto");
    
                                    System.out.printf("| %-29s | %-8d | %-17s |\n", nombre, ciudadId, numero);
                                }
                                System.out.println("+-------------------------------+----------+-------------------+");
    
                            }  catch (SQLException e) {
                                e.printStackTrace();
                                System.out.println("\n\nError al actualizar el aeropuerto con ID: " + numeroAeropuerto);
                                System.out.println("Error de sistema: " + e);
                            } 
                        }
                    
                    } catch (SQLIntegrityConstraintViolationException b) {
                        String mensaje = b.getMessage();
                        if (mensaje.contains("Ciudad_id")) {
                            System.out.println("Error: Error con el codigo de la ciudad no existe o es invalido");
                        }
                       
                        
                    } catch (Exception e) {
                        System.out.println("Error al actualizar la ciudad");
                    }
                    break;

                case 3:
                    System.out.println("Digita el nuevo numero serial");
                    String nuevoSerial = CheckString.check("Digita de nuevo el numero serial");

                    sql = "{call actualizarNumeroSerial(?, ?)}";

                    stmt = (CallableStatement) connection.prepareCall(sql);

                    stmt.setString(1, numeroAeropuerto);
                    stmt.setString(2, nuevoSerial);

                    System.out.println("Ejecutando el procedimiento almacenado para actualizar los datos del aeropuerto...");

                    try {
                        hasResult = stmt.execute();

                        
                    if (hasResult) {
                        try (ResultSet rs = stmt.getResultSet()) {

                            System.out.println("+-------------------------------+----------+-------------------+");
                            System.out.printf("| %-29s | %-8s | %-17s |\n", "Nombre", "Ciudad ID", "Número de Aeropuerto");
                            System.out.println("+-------------------------------+----------+-------------------+");

                            while (rs.next()) {
                                String nombre = rs.getString("nombre");
                                int ciudadId = rs.getInt("Ciudad_id");
                                String numero = rs.getString("numeroAeropuerto");

                                System.out.printf("| %-29s | %-8d | %-17s |\n", nombre, ciudadId, numero);
                            }
                            System.out.println("+-------------------------------+----------+-------------------+");

                        } 
                        catch (SQLException e) {
                            e.printStackTrace();
                            System.out.println("\n\nError al actualizar el aeropuerto con ID: " + numeroAeropuerto);
                            System.out.println("Error de sistema: " + e);
                        } 
                    }

                    }catch (SQLIntegrityConstraintViolationException b) {
                           
                        System.out.println("Error. El numero del aeropeurto es invalido o ya existe");
                        
                    } 
                     catch (Exception e) {
                        // TODO: handle exception
                    }
                    

                    break;

                default:
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al intentar actualizar el aeropuerto con ID: " + numeroAeropuerto);
            System.out.println("Error de sistema: " + e);
        }
    }
}
