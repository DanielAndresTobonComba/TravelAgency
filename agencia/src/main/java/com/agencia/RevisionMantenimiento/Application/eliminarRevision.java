package com.agencia.RevisionMantenimiento.Application;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RevisionMantenimiento.Adapter.In.controladorEliminarRevision;

public class eliminarRevision extends Funcionalidad {

    public eliminarRevision(String enunciado) {
        this.enunciado = enunciado;
        
    }

    @Override
    public void ejecutar(Empleado empleado) {
        controladorEliminarRevision controladorEliminarRevision = new controladorEliminarRevision(); 
        controladorEliminarRevision.tomarDatos();
    }

}
