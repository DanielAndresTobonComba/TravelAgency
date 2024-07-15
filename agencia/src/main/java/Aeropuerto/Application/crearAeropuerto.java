package Aeropuerto.Application;

import Aeropuerto.Domain.Entity.Aeropuerto;
import Aeropuerto.Domain.Service.interfazCrearAeropuerto;

public class crearAeropuerto  {

    private final interfazCrearAeropuerto servicio;


    public crearAeropuerto (interfazCrearAeropuerto servicio ) {
        this.servicio = servicio;
        
    } 

    public void ejecutar (Aeropuerto aeropuerto) {
        servicio.crearAeropuerto(aeropuerto);
    }

}
