package com.agencia.Aeropuerto.Application;

import com.agencia.Aeropuerto.Domain.Service.interfazEliminarAeropuerto;

public class eliminarAeropuerto {

    private final interfazEliminarAeropuerto eliminarAeropuerto ;

    public eliminarAeropuerto(interfazEliminarAeropuerto eliminarAeropuerto) {
        this.eliminarAeropuerto = eliminarAeropuerto;
    }

    public void ejecutarEliminarAeropuerto (String numeroAeropuerto){
        eliminarAeropuerto.eliminarAeropuerto(numeroAeropuerto);
    }
}
