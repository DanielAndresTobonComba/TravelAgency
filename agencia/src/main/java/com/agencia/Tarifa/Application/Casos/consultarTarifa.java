package com.agencia.Tarifa.Application.Casos;

import com.agencia.Tarifa.Application.Service.InterfazConsultaTarifa;

public class consultarTarifa {

    private final InterfazConsultaTarifa servicio;

    public consultarTarifa(InterfazConsultaTarifa servicio) {
        this.servicio = servicio;
    } 

    public void tomarNumeroTarifa (int numeroTarifa) {

        servicio.consultarTarifa(numeroTarifa);
    }

}
