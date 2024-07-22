package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.Aeropuerto.Application.consultarAeropuerto;
import com.agencia.Aeropuerto.MainAeropuerto.MainMenuAeropuerto;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckString;

public class controladorConsultarAeropuerto {

    private final consultarAeropuerto servicioConsultarAeropuerto;
    private Empleado empleado;

    

    public controladorConsultarAeropuerto(consultarAeropuerto servicioConsultarAeropuerto, Empleado empleado) {
        this.servicioConsultarAeropuerto = servicioConsultarAeropuerto;
        this.empleado = empleado;
    }



    public void tomarNumAeropuerto() {
        System.out.println("Digita el número del aeropuerto a consultar");
        String numeroAeropuerto = CheckString.check("Digita de nuevo el número del aeropuerto");

        servicioConsultarAeropuerto.ejecutarConsultarAeropuerto(numeroAeropuerto);
        MainMenuAeropuerto.main(empleado);
        
        
    }
    
    

}
