package com.agencia.Tarifa.Application.Casos.ActualizarTarifa;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.In.ActualizarTarifa.controladorActualizarDescripcionTarifa;
import com.agencia.Tarifa.Domain.actualizarDatosTarifa;

public class actualizarDescripcionTarifa extends actualizarDatosTarifa {

    public actualizarDescripcionTarifa(String enunciado) {
        this.enunciado = enunciado;
        
    }

    @Override
    public void actualizar(String numeroTarifa , Empleado empleado) {

        controladorActualizarDescripcionTarifa actualizarDescripcionTarifa = new controladorActualizarDescripcionTarifa(); 

        actualizarDescripcionTarifa.tomarDatos(numeroTarifa , empleado);
       
    }

}
