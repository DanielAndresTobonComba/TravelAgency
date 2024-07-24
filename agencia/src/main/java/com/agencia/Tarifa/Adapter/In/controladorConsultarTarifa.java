package com.agencia.Tarifa.Adapter.In;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.repoConsultarTarifa;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckInt;

public class controladorConsultarTarifa { 

/*     private final consultarTarifa consultarTarifa; 

    

    public controladorConsultarTarifa(com.agencia.Tarifa.Application.Casos.consultarTarifa consultarTarifa) {
        this.consultarTarifa = consultarTarifa;
    } */



    public static void tomarNumeroTarifa (Empleado empleado) {

        System.out.println("Digita el numero de la tarifa");

        int numeroTarifa = CheckInt.check("Digite de nuevo el numero de la tarifa");


        repoConsultarTarifa consultarTarifa = new repoConsultarTarifa(); 

        consultarTarifa.consultarTarifa(numeroTarifa);
        MainTarifa.main(empleado);

    }

}
