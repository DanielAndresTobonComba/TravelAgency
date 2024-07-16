package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.Aeropuerto.Application.consultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioConsultarAeropuerto;

import com.agencia.Verifiers.CheckString;

public class controladorConsultarAeropuerto {

    private final consultarAeropuerto servicioConsultarAeropuerto;

    

    public controladorConsultarAeropuerto(consultarAeropuerto servicioConsultarAeropuerto) {
        this.servicioConsultarAeropuerto = servicioConsultarAeropuerto;
    }



    public void tomarNumAeropuerto() {
        System.out.println("Digita el número del aeropuerto a consultar");
        String numeroAeropuerto = CheckString.check("Digita de nuevo el número del aeropuerto");
        
        repositorioConsultarAeropuerto consultarAeropuerto = new repositorioConsultarAeropuerto();
        consultarAeropuerto.consultarAeropuerto(numeroAeropuerto);
    }
    
    

}
