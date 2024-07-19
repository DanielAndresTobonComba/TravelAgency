package com.agencia.Tarifa.Application.Casos;

import com.agencia.Tarifa.Application.Service.InterfazAgregarTarifa;
import com.agencia.Tarifa.Domain.Tarifa;

public class agregarTarifa {

    private final InterfazAgregarTarifa servicioAgregarTarifa ;

    public agregarTarifa(InterfazAgregarTarifa servicioAgregarTarifa) {
        this.servicioAgregarTarifa = servicioAgregarTarifa;
    } 

    
    public void ejecutarAgregarTarifa (Tarifa tarifa) {

        servicioAgregarTarifa.agregar(tarifa);
    }

}
