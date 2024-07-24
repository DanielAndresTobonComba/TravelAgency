package com.agencia.Tarifa.Application.Casos.ActualizarTarifa;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.In.ActualizarTarifa.controladorActualizarDetallesTarifa;
import com.agencia.Tarifa.Domain.actualizarDatosTarifa;

public class actualizarDetallesTarifa extends actualizarDatosTarifa {

    
    public actualizarDetallesTarifa(String enunciado) {
        this.enunciado = enunciado;

    }

    @Override
    public void actualizar(String numeroTarifa , Empleado empleado) {
        
        controladorActualizarDetallesTarifa actualizarDetallesTarifa = new controladorActualizarDetallesTarifa();

        actualizarDetallesTarifa.tomarDatalle(numeroTarifa , empleado);
    }

}
