package com.agencia.AbstractClasses;

import com.agencia.LogIn.Domain.Empleado;

public abstract  class Funcionalidad {

    public String enunciado, codigo;

    //public Empleado empleado;

    public  abstract void ejecutar(Empleado empleado);

}
