package com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos;

import java.sql.Date;

import com.agencia.RevisionMantenimiento.Adapter.Out.ActualizarRevision.repoActualizarFechaRevision;
import com.agencia.Verifiers.CheckDate;

public class controladorActualizarFechaRevision {

    public void tomarDatos (String numeroRevision) {

        System.out.println("Digita la nueva fecha de revisiòn");
        String fecha = CheckDate.check("Digita de nuevo la fecha"); 

        repoActualizarFechaRevision actualizarFechaRevision = new repoActualizarFechaRevision(); 
        actualizarFechaRevision.ejecutarActualizarFechaRevision(numeroRevision , fecha);


    }

}
