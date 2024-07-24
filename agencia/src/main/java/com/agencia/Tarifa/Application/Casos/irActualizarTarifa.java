package com.agencia.Tarifa.Application.Casos;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.MainTarifa.MainActualizarTarifa;

public class irActualizarTarifa extends Funcionalidad {

    public irActualizarTarifa(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar(Empleado empleado) {
        MainActualizarTarifa.main(empleado);
    }

}
