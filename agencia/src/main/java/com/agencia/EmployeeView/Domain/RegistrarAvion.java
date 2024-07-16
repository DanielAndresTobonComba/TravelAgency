package com.agencia.EmployeeView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.MainLogIn.MainLogIn;

public class RegistrarAvion  extends Funcionalidad{

    public RegistrarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println("Aquí se va a registrar un avión");
    }

}
