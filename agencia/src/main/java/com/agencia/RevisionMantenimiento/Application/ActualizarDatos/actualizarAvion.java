package com.agencia.RevisionMantenimiento.Application.ActualizarDatos;

import com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos.controladorActualizarAvion;
import com.agencia.RevisionMantenimiento.Domain.actualizarDatosRevision;

public class actualizarAvion extends actualizarDatosRevision {


    public actualizarAvion (String enunciado) {
        this.enunciado = enunciado;
    }

    @Override
    public void actualizar(String numeroRevision) {

        controladorActualizarAvion actualizarAvion = new controladorActualizarAvion();

        actualizarAvion.tomarDatos(numeroRevision);
        
    }

}
