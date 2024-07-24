package com.agencia.Tarifa.Application.Casos;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.MainAeropuerto.MainActualizarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.MainTarifa.MainCrearTarifa;
import com.agencia.Tarifa.MainTarifa.MainTarifa;

public class IrCrearTarifa extends Funcionalidad {

    public IrCrearTarifa(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }


    @Override
    public void ejecutar(Empleado empleado) {
        
        MainCrearTarifa.main(empleado);

    }

}
