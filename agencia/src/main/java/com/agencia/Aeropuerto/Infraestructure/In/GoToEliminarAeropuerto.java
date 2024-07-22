package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.MainAeropuerto.MainEliminarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class GoToEliminarAeropuerto extends Funcionalidad {

    public GoToEliminarAeropuerto(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainEliminarAeropuerto.main(empleado);

    }

}
