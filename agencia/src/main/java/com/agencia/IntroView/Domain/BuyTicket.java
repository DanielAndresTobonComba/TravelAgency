package com.agencia.IntroView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.LogIn.MainLogIn.MainLogIn;

public class BuyTicket extends Funcionalidad {

    public BuyTicket(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar(Empleado empleado) {
        System.out.println("Cliente pasa a comprar");
    }

}
