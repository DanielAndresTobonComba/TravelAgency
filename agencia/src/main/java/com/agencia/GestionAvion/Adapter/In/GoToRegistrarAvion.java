package com.agencia.GestionAvion.Adapter.In;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.GestionAvion.Main.MainAirplaneRegistration;
import com.agencia.LogIn.Domain.Empleado;

public class GoToRegistrarAvion extends Funcionalidad {

    public GoToRegistrarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }


    @Override
    public void ejecutar(Empleado empleado) {
        MainAirplaneRegistration.mainAirplaneRegistration(empleado);
    }

}
