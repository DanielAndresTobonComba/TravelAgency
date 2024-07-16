package com.agencia.EmployeeView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;

public class ActualizarAvion extends Funcionalidad {

    public ActualizarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println("Aquí se va a actualizar un avión");

    }
}