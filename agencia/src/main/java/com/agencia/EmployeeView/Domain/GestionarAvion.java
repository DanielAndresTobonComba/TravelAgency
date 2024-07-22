package com.agencia.EmployeeView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.GestionAvion.Main.MainMenuGestionAvion;
import com.agencia.LogIn.Domain.Empleado;

public class GestionarAvion extends Funcionalidad {

    public GestionarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainMenuGestionAvion.main(empleado);

    }

}
