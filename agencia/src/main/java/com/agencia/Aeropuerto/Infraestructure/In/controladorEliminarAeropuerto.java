package com.agencia.Aeropuerto.Infraestructure.In;

import java.util.Scanner;

import com.agencia.Aeropuerto.Application.eliminarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioEliminarAeropuerto;
import com.agencia.Verifiers.CheckString;

public class controladorEliminarAeropuerto {

    Scanner sc = new Scanner(System.in);
    private final eliminarAeropuerto eliminarAeropuerto;

    
    public controladorEliminarAeropuerto(eliminarAeropuerto eliminarAeropuerto) {
        this.eliminarAeropuerto = eliminarAeropuerto;
    }

    public void tomarNumAeropuerto() {
        System.out.println("Digita el número del aeropuerto a eliminar");
        String numeroAeropuerto = CheckString.check("Digita de nuevo el número del aeropuerto");
        
        repositorioEliminarAeropuerto eliminarAeropuerto = new repositorioEliminarAeropuerto();
        eliminarAeropuerto.eliminarAeropuerto(numeroAeropuerto);
    }

}
