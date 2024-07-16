package com.agencia.Aeropuerto.Infraestructure.In;

import java.util.Scanner;

import com.agencia.Aeropuerto.Application.crearAeropuerto;
import com.agencia.Aeropuerto.Domain.Entity.Aeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioCrearAeropuerto;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class controladorCrearAeropuerto {

    Scanner sc = new Scanner(System.in);

    private final crearAeropuerto servicioCrearAeropuerto;

    public controladorCrearAeropuerto(crearAeropuerto servicioCrearAeropuerto) {
        this.servicioCrearAeropuerto = servicioCrearAeropuerto;
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

            repositorioCrearAeropuerto repositorioCrearAeropuerto = new repositorioCrearAeropuerto();
            repositorioCrearAeropuerto.crearAeropuerto(aeropuerto);

            
        } catch (Exception e) {
            System.out.println("Error al crear el aeropuerto");
        }
    }

}
