package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarDescripcion;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarDescripcionTarifa {

    public void tomarDatos (String numeroTarifa) {
        
        System.out.println("Digita la nueva descripción ");
        String descripcion = CheckString.check("Digita de nuevo la descripción"); 

        repoActualizarDescripcion repoActualizarDescripcion = new repoActualizarDescripcion(); 
        repoActualizarDescripcion.ejecutarActualizarDescripcion(numeroTarifa , descripcion);
    }

}
