package com.agencia.Aeropuerto.Application;

import com.agencia.Aeropuerto.Domain.Entity.Aeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazCrearAeropuerto;

public class crearAeropuerto  {

    private final interfazCrearAeropuerto servicio;


    public crearAeropuerto (interfazCrearAeropuerto servicio ) {
        this.servicio = servicio;
        
    } 

    public void ejecutar (Aeropuerto aeropuerto) {
        servicio.crearAeropuerto(aeropuerto);
    }

}
