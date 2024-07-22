package com.agencia.Aeropuerto.Infraestructure.In;

import java.util.Scanner;

import com.agencia.Aeropuerto.Application.eliminarAeropuerto;
import com.agencia.Aeropuerto.MainAeropuerto.MainMenuAeropuerto;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckString;

public class controladorEliminarAeropuerto {


    private final eliminarAeropuerto eliminarAeropuerto;
    private Empleado empleado;

    
    public controladorEliminarAeropuerto(eliminarAeropuerto eliminarAeropuerto, Empleado empleado) {
        this.eliminarAeropuerto = eliminarAeropuerto;
        this.empleado = empleado;
    }

    public void tomarNumAeropuerto() {
        System.out.println("Digita el número del aeropuerto a eliminar");
        String numeroAeropuerto = CheckString.check("Digita de nuevo el número del aeropuerto");

        eliminarAeropuerto.ejecutarEliminarAeropuerto(numeroAeropuerto);
        MainMenuAeropuerto.main(empleado);
        
    }

}
