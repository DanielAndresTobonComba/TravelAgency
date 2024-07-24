package com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos;

import com.agencia.RevisionMantenimiento.Adapter.Out.ActualizarRevision.repoActualizarDescripcionRevision;
import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarDescripcion;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarDescripcion {
    
    public void tomarDatos (String numeroRevision) {
        System.out.println("\n===================================");
        System.out.println("        ACTUALIZAR REVISIÒN");
        System.out.println("===================================\n");

        System.out.print("Nueva descripciòn >>>> ");

        String descripcion = CheckString.check("Digita de nuevo la descripciòn"); 

        if(descripcion.length() > 70) {
            System.out.println("La descripciòn supera el nùmero de caracteres maximo (70)");
            
            controladorActualizarDescripcion actualizarDescripcion = new controladorActualizarDescripcion();

            actualizarDescripcion.tomarDatos(numeroRevision);
        } 

        repoActualizarDescripcionRevision repoActualizarDescripcion = new repoActualizarDescripcionRevision(); 
        
        repoActualizarDescripcion.ejecutarActualizarDescripcion(numeroRevision, descripcion);

    }

}
