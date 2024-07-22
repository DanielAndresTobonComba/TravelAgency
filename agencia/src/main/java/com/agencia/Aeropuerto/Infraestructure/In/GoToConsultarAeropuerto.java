package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.MainAeropuerto.MainConsultarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class GoToConsultarAeropuerto extends Funcionalidad {

    public GoToConsultarAeropuerto(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainConsultarAeropuerto.main(empleado);

    }

}
