package com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos;

import java.sql.Date;

import com.agencia.RevisionMantenimiento.Adapter.Out.ActualizarRevision.repoActualizarFechaRevision;
import com.agencia.Verifiers.CheckDate;

public class controladorActualizarFechaRevision {

    public void tomarDatos (String numeroRevision) {

        System.out.println("===================================");
        System.out.println("    ACTUALIZAR FECHA REVISION ");
        System.out.println("===================================\n");

        System.out.print("Nueva fecha [AAAA-MM-DD] >>>> ");
        String fecha = CheckDate.check("Digita de nuevo la fecha"); 

        repoActualizarFechaRevision actualizarFechaRevision = new repoActualizarFechaRevision(); 
        actualizarFechaRevision.ejecutarActualizarFechaRevision(numeroRevision , fecha);


    }

}
