package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.MainAeropuerto.MainActualizarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class GoToActualizarAeropuerto extends Funcionalidad {

    public GoToActualizarAeropuerto(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainActualizarAeropuerto.main(empleado);

    }


}
