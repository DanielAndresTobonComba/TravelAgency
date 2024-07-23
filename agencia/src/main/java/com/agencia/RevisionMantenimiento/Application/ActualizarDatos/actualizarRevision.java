package com.agencia.RevisionMantenimiento.Application.ActualizarDatos;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos.menuActualizarRevision;

public class actualizarRevision extends Funcionalidad {

    public actualizarRevision(String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public void ejecutar(Empleado empleado) {
        menuActualizarRevision menuActualizarRevision = new menuActualizarRevision(); 

        menuActualizarRevision.ejecutarMenu(empleado);
    }

}
