package com.agencia.Tarifa.Application.Casos.ActualizarTarifa;

import com.agencia.Tarifa.Adapter.In.ActualizarTarifa.controladorActualizarImpuestoTarifa;
import com.agencia.Tarifa.Domain.actualizarDatosTarifa;

public class actualizarImpuestoTarifa extends actualizarDatosTarifa{

    public actualizarImpuestoTarifa(String enunciado) {
        this.enunciado = enunciado;

    }


    @Override
    public void actualizar(String numeroTarifa) {
        controladorActualizarImpuestoTarifa actualizarImpuestoTarifa = new controladorActualizarImpuestoTarifa();

        actualizarImpuestoTarifa.tomarImpuesto(numeroTarifa);
    }

}
