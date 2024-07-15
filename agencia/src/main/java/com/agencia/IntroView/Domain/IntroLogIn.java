package com.agencia.IntroView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;

public class IntroLogIn extends Funcionalidad {
    
    

    public IntroLogIn(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println("Holita!");
    }

}
