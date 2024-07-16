package com.agencia.IntroView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;

public class Exit extends Funcionalidad {

    public Exit(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }

    @Override
    public void ejecutar() {
        System.out.println("\n _ - _ - _ - _ - _ - _ - _ - _ - _ - _");
        System.out.println("|      T R A V E L  A G E N C Y      |");
        System.out.println("|                                    |");
        System.out.println("|               B Y E!               |");
        System.out.println("- _ - _ - _ - _ - _ - _ - _ - _ - _ -\n");

    }

}
