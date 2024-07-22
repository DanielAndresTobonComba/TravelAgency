package com.agencia.RevisionMantenimiento.Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.AbstractClasses.imprimirTabla;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;

public class imprimirHistorialRevision extends imprimirTabla {

    @Override
    public void imprimir(ResultSet rs) throws SQLException {

        try {
            if (rs.next()) {
                System.out.println("\nHISTORIAL DE REVISION ENCONTRADO");

                // Imprimir encabezado de la tabla
                System.out.println("+-------------------------------+-------------------+--------------------------+");
                System.out.printf("| %-15s | %-20s | %-20s | %-12s |\n", "Placa Avion", "Modelo", "Fecha Fabricacion", "Capacidad");
                System.out.println("+-------------------------------+-------------------+--------------------------+");

                // Obtener y mostrar los datos del primer registro
                String placa = rs.getString("Placa");
                String modelo = rs.getString("Modelo");
                String fechaFabricacion = rs.getString("fechaFabricacion");
                int capacidad = rs.getInt("Capacidad");
                System.out.printf("| %-15s | %-20s | %-20s | %-12d |\n", placa, modelo, fechaFabricacion, capacidad);

                System.out.println("+-------------------------------+-------------------+--------------------------+\n\n");

                System.out.println("+-------------------------------+-------------------+-------------------+-------------------+--------------------+");
                System.out.printf("| %-15s | %-20s | %-70s|\n", "idRevision", "Fecha Mantenimiento", "Descripcion");
                System.out.println("+-------------------------------+-------------------+-------------------+-------------------+--------------------+");

                // Mostrar los datos restantes del ResultSet
                do {
                    String id = rs.getString("idRevision");
                    String fechaMantenimiento = rs.getString("fechaMantenimiento");
                    String descripcion = rs.getString("Descripcion");

                    System.out.printf("| %-15s | %-20s | %-70s|\n", id, fechaMantenimiento, descripcion);
                } while (rs.next());

                System.out.println("+-------------------------------+-------------------+-------------------+-------------------+--------------------+");
            } else {
                System.out.println("El avion no posee un historial de revision");
                System.out.println("Presiona enter para volver al menu");
                MainRevisionMantenimiento.main(); // Llamada correcta a MainRevisionMantenimiento.main
            }

        } catch (SQLException e) {
            System.out.println("Error al imprimir el historial: " + e.getMessage());
        }

    }

}
