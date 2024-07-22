package com.agencia.GestionAvion.Adapter;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.EliminarAvion.Main.MainEliminarAvion;
import com.agencia.LogIn.Domain.Empleado;

public class GoToEliminarAvion extends Funcionalidad {

    public GoToEliminarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        MainEliminarAvion.main(empleado);
    }



}
