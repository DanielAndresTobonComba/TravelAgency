package com.agencia.Tarifa.Adapter.In;

import com.agencia.Tarifa.Application.Casos.eliminarTarifa;
import com.agencia.Verifiers.CheckInt;

public class controladorEliminarTarifa {

    private final eliminarTarifa eliminarTarifa;

    public controladorEliminarTarifa( eliminarTarifa eliminarTarifa) {
        this.eliminarTarifa = eliminarTarifa;
    } 

    public void ejecutarEliminarTarifa () {

        System.out.println("Digita el numero de la tarifa");
        int numeroTarifa = CheckInt.check("Digita el numero de tarifa de nuevo");

       eliminarTarifa.tomarNumeroTarifa(numeroTarifa);
    }
}
