package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarPrecio;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarPrecioTarifa {

    public void tomarPrecio (String numeroTarifa) {

        System.out.println("Digita el nuevo precio con este formato (0.0)");
        String nuevoPrecio = CheckString.check("Digita de nuevo el precio"); 

        repoActualizarPrecio repoActualizarPrecio = new repoActualizarPrecio(); 
        repoActualizarPrecio.ejecutarActualizarPrecio(numeroTarifa , nuevoPrecio);
    }

}
