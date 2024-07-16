package com.agencia.Aeropuerto.Application;

import com.agencia.Aeropuerto.Domain.Service.interfazActualizarAeropuerto;

public class actualizarAeropuerto {

    private final interfazActualizarAeropuerto servicioActualizarAeropuerto;

    

    public actualizarAeropuerto(interfazActualizarAeropuerto servicioActualizarAeropuerto) {
        this.servicioActualizarAeropuerto = servicioActualizarAeropuerto;
    }



    public void ejecutarActualizarDatos (String numeroAeropuerto , int opcion) {
        servicioActualizarAeropuerto.actualizarAeropuerto(numeroAeropuerto , opcion);
    }
    
}
