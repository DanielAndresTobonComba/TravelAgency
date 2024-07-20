package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.Aeropuerto.Application.actualizarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioActualizarAeropuerto;
import com.agencia.Aeropuerto.MainAeropuerto.MainActualizarAeropuerto;
import com.agencia.Aeropuerto.MainAeropuerto.MainMenuAeropuerto;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarAeropuerto {

    private final actualizarAeropuerto actualizarAeropuerto;
    private Empleado empleado;

    public controladorActualizarAeropuerto(actualizarAeropuerto actualizarAeropuerto, Empleado empleado) {
        this.actualizarAeropuerto = actualizarAeropuerto;
        this.empleado = empleado;
    }

    

    public void actualizarAeropuerto() {

        System.out.println("Digita el numero del aeropuerto");

        String numeroAeropuerto = CheckString.check("Digita de nuevo el numero del aeropuerto");
        int opcion;

        //repositorioActualizarAeropuerto actualizarAeropuertoRepo = new repositorioActualizarAeropuerto();

        do {

            System.out.println("\nMenu de eleccion");
            System.out.println("1. Nombre");
            System.out.println("2. Ciudad");
            System.out.println("3. Numero serial");
            System.out.println("4. Salir");

            opcion = CheckInt.check("Digite de nuevo la opcion a modificar");

            actualizarAeropuerto.ejecutarActualizarDatos(numeroAeropuerto, opcion);
            MainMenuAeropuerto.main(empleado);

            //actualizarAeropuertoRepo.actualizarAeropuerto(numeroAeropuerto, opcion);

        } while (opcion != 4);
    }
}
