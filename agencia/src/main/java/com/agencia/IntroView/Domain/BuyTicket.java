package com.agencia.IntroView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;

public class BuyTicket extends Funcionalidad{


    public BuyTicket(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println("Vamos a comprar un ticket");
    }

}
