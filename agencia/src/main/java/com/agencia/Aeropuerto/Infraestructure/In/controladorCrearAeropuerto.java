package com.agencia.Aeropuerto.Infraestructure.In;

import java.util.Scanner;

import com.agencia.Aeropuerto.Application.crearAeropuerto;
import com.agencia.Aeropuerto.Domain.Entity.Aeropuerto;
import com.agencia.Aeropuerto.MainAeropuerto.MainMenuAeropuerto;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class controladorCrearAeropuerto {

    Scanner sc = new Scanner(System.in);

    private final crearAeropuerto servicioCrearAeropuerto;
    private Empleado empleado;

    public controladorCrearAeropuerto(crearAeropuerto servicioCrearAeropuerto, Empleado empleado) {
        this.servicioCrearAeropuerto = servicioCrearAeropuerto;
        this.empleado = empleado;
    }

    public void tomarDatosAeropuerto (){

        try {
            System.out.println("Digite el numero de identifición del aeropuerto");
            String numAeropuerto = CheckString.check("Digita de nuevo numero del aeropuerto");
            
            System.out.println("Digite el nombre del aeropuerto");
            String nombreAeropuerto = CheckString.check("Digita de nuevo el nombre del aeropuerto");

            System.out.println("Digite el codigo de la ciudad");
            int idCiudad = CheckInt.check("Digita de nuevo el id de la ciudad");

            Aeropuerto aeropuerto = new Aeropuerto(); 

            aeropuerto.setNombre(nombreAeropuerto);
            aeropuerto.setNumAeropuerto(numAeropuerto);
            aeropuerto.setIdCiudad(idCiudad);

            servicioCrearAeropuerto.ejecutar(aeropuerto);
            MainMenuAeropuerto.main(empleado);


            
        } catch (Exception e) {
            System.out.println("Error al crear el aeropuerto");
        }
    }

}