package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarDetalle;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarDetallesTarifa {

    public void tomarDatalle (String numeroTarifa) {

        System.out.println("Digita el nuevo detalle");
        String descripcion = CheckString.check("Digita de nuevo el detalle"); 

        repoActualizarDetalle repoActualizarDetalle = new repoActualizarDetalle();
        repoActualizarDetalle.ejecutarActualizarDetalle(numeroTarifa, descripcion);
    }

}
