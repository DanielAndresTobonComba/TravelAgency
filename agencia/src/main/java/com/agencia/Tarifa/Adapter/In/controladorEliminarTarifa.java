package com.agencia.Tarifa.Adapter.In;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.repoEliminarTarifa;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckInt;

public class controladorEliminarTarifa {

/*     private final eliminarTarifa eliminarTarifa;

    public controladorEliminarTarifa( eliminarTarifa eliminarTarifa) {
        this.eliminarTarifa = eliminarTarifa;
    }  */

    public static void ejecutarEliminarTarifa (Empleado empleado) {

        System.out.println("Digita el numero de la tarifa");
        int numeroTarifa = CheckInt.check("Digita el numero de tarifa de nuevo");

        repoEliminarTarifa eliminarTarifa = new repoEliminarTarifa(); 
        eliminarTarifa.eliminar(numeroTarifa);
        MainTarifa.main(empleado);
    }
}
