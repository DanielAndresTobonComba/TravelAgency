package com.agencia.Tarifa.Application.Casos.ActualizarTarifa;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.In.ActualizarTarifa.controladorActualizarPrecioTarifa;
import com.agencia.Tarifa.Domain.actualizarDatosTarifa;

public class actualizarPrecioTarifa extends actualizarDatosTarifa{

    
    public actualizarPrecioTarifa(String enunciado) {
        this.enunciado = enunciado;

    }


    @Override
    public void actualizar(String numeroTarifa , Empleado empleado) {
            controladorActualizarPrecioTarifa actualizarPrecioTarifa = new controladorActualizarPrecioTarifa();

            actualizarPrecioTarifa.tomarPrecio(numeroTarifa , empleado);
    }

}
