package com.agencia.EmployeeView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.MainAeropuerto.MainMenuAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class GestionarAeropuerto extends Funcionalidad {

    public GestionarAeropuerto(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainMenuAeropuerto.main();

    }

}
