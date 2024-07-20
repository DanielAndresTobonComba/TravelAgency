package com.agencia.GestionAvion.Adapter;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Main.MainAirplaneRegistration;

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
