package com.agencia.Tarifa.Application.Casos;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.MainTarifa.MainCrearTarifa;
import com.agencia.Tarifa.MainTarifa.MainEliminarTarifa;

public class irEliminarTarifa extends Funcionalidad {

    public irEliminarTarifa(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }


    @Override
    public void ejecutar(Empleado empleado) {
        
        MainEliminarTarifa.main(empleado);

    }

}
