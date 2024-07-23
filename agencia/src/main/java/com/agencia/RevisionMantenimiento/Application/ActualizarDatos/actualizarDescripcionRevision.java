package com.agencia.RevisionMantenimiento.Application.ActualizarDatos;

import com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos.controladorActualizarDescripcion;
import com.agencia.RevisionMantenimiento.Domain.actualizarDatosRevision;

public class actualizarDescripcionRevision extends actualizarDatosRevision {

    public actualizarDescripcionRevision(String enunciado) {
        this.enunciado = enunciado;
    }


    @Override
    public void actualizar(String numeroRevision) {

        controladorActualizarDescripcion actualizarDescripcion = new controladorActualizarDescripcion(); 
        
        actualizarDescripcion.tomarDatos(numeroRevision);
        
    }

}
