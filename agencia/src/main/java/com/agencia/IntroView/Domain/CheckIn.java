package com.agencia.IntroView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.CheckIn.MainCheckIn.MainCheckIn;
import com.agencia.LogIn.Domain.Empleado;

public class CheckIn extends Funcionalidad {

    public CheckIn(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar(Empleado empleado) {
        MainCheckIn.main();
    }



}
