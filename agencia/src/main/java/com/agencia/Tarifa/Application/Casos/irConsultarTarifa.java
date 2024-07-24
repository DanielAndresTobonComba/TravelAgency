package com.agencia.Tarifa.Application.Casos;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.MainTarifa.MainConsultarTarifa;

public class irConsultarTarifa extends Funcionalidad{


    public irConsultarTarifa(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar(Empleado empleado) {
        MainConsultarTarifa.main(empleado);
    }
}
