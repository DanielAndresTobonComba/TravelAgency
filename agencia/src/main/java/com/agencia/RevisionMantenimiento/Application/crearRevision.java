package com.agencia.RevisionMantenimiento.Application;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RevisionMantenimiento.Adapter.In.controladorCrearRevision;

public class crearRevision extends Funcionalidad {

    public crearRevision(String enunciado) {
        this.enunciado = enunciado;
        
    }


    @Override
    public void ejecutar(Empleado empleado) {
        controladorCrearRevision crearRevision = new controladorCrearRevision(); 
        crearRevision.tomarDatos();
    }

}
