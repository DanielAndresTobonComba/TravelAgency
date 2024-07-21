package com.agencia.Tarifa.Application.Casos.ActualizarTarifa;

import com.agencia.Tarifa.Adapter.In.ActualizarTarifa.controladorActualizarDetallesTarifa;
import com.agencia.Tarifa.Domain.actualizarDatosTarifa;

public class actualizarDetallesTarifa extends actualizarDatosTarifa {

    
    public actualizarDetallesTarifa(String enunciado) {
        this.enunciado = enunciado;

    }

    @Override
    public void actualizar(String numeroTarifa) {
        
        controladorActualizarDetallesTarifa actualizarDetallesTarifa = new controladorActualizarDetallesTarifa();

        actualizarDetallesTarifa.tomarDatalle(numeroTarifa);
    }

}
