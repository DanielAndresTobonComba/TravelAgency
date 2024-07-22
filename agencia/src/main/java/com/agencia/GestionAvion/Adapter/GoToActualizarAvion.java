package com.agencia.GestionAvion.Adapter;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.ActualizarAvion.MainActualizarAvion.MainActualizarAvion;
import com.agencia.LogIn.Domain.Empleado;

public class GoToActualizarAvion extends Funcionalidad {

    public GoToActualizarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainActualizarAvion.main(empleado);

    }

}
