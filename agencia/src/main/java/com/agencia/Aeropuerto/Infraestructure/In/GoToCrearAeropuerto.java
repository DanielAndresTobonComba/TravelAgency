package com.agencia.Aeropuerto.Infraestructure.In;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.MainAeropuerto.MainCrearAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class GoToCrearAeropuerto extends Funcionalidad {

    public GoToCrearAeropuerto(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainCrearAeropuerto.main(empleado);

    }


}
