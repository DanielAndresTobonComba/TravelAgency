package com.agencia.RevisionMantenimiento.Application;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RevisionMantenimiento.Adapter.In.controladorConsultarHistorial;

public class consultarHistorial extends Funcionalidad {

    public consultarHistorial(String enunciado) {
        this.enunciado = enunciado;
    }


    @Override
    public void ejecutar(Empleado empleado) {
        controladorConsultarHistorial consultarHistorial = new controladorConsultarHistorial(); 
        consultarHistorial.tomarDatos();
    }

}
