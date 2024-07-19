package com.agencia.EmployeeView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.LogIn.MainLogIn.MainLogIn;
import com.agencia.RegistrarAvion.Main.MainAirplaneRegistration;

public class RegistrarAvion  extends Funcionalidad{

    

    public RegistrarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }





    

    @Override
    public void ejecutar(Empleado empleado) {
        MainAirplaneRegistration.mainAirplaneRegistration(empleado);
    }

}
