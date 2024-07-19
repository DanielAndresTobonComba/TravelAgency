package com.agencia.Tarifa.Adapter.In;

import com.agencia.Tarifa.Application.Casos.consultarTarifa;
import com.agencia.Verifiers.CheckInt;

public class controladorConsultarTarifa { 

    private final consultarTarifa consultarTarifa; 

    

    public controladorConsultarTarifa(com.agencia.Tarifa.Application.Casos.consultarTarifa consultarTarifa) {
        this.consultarTarifa = consultarTarifa;
    }



    public void tomarNumeroTarifa () {

        System.out.println("Digita el numero de la tarifa");

        int numeroTarifa = CheckInt.check("Digite de nuevo el numero de la tarifa");


        consultarTarifa.tomarNumeroTarifa(numeroTarifa);

    }

}
