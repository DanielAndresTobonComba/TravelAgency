package com.agencia.Tarifa.Application.Casos;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.MainTarifa.MainTarifa;

public class GestionTarifa extends Funcionalidad {

    public GestionTarifa(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar(Empleado empleado) {
       
        MainTarifa.main(empleado);

    }

}
