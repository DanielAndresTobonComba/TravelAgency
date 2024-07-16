package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.Aeropuerto.Application.actualizarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioActualizarAeropuerto;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarAeropuerto {

    private final actualizarAeropuerto actualizarAeropuerto;

    public controladorActualizarAeropuerto(com.agencia.Aeropuerto.Application.actualizarAeropuerto actualizarAeropuerto) {
        this.actualizarAeropuerto = actualizarAeropuerto;
    }

    

    public void actualizarAeropuerto() {

        System.out.println("Digita el numero del aeropuerto");

        String numeroAeropuerto = CheckString.check("Digita de nuevo el numero del aeropuerto");
        int opcion;

        repositorioActualizarAeropuerto actualizarAeropuertoRepo = new repositorioActualizarAeropuerto();

        do {

            System.out.println("\nMenu de eleccion");
            System.out.println("1. Nombre");
            System.out.println("2. Ciudad");
            System.out.println("3. Numero serial");
            System.out.println("4. Salir");

            opcion = CheckInt.check("Digite de nuevo la opcion a modificar");

            actualizarAeropuertoRepo.actualizarAeropuerto(numeroAeropuerto, opcion);

        } while (opcion != 4);
    }
}
