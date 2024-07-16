package com.agencia.Aeropuerto.Application;

import com.agencia.Aeropuerto.Domain.Service.interfazConsultarAeropuerto;

public class consultarAeropuerto {

    private final interfazConsultarAeropuerto servicioConsultarAeropuerto;

    public consultarAeropuerto(interfazConsultarAeropuerto servicioConsultarAeropuerto) {
        this.servicioConsultarAeropuerto = servicioConsultarAeropuerto;
    }

    public void ejecutarConsultarAeropuerto (String numeroAeropuerto) {
        servicioConsultarAeropuerto.consultarAeropuerto(numeroAeropuerto);
    }

}
