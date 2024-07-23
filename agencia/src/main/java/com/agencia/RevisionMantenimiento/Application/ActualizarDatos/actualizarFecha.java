package com.agencia.RevisionMantenimiento.Application.ActualizarDatos;

import com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos.controladorActualizarFechaRevision;
import com.agencia.RevisionMantenimiento.Domain.actualizarDatosRevision;

public class actualizarFecha extends actualizarDatosRevision {


    public actualizarFecha(String enunciado) {
        this.enunciado = enunciado;
    }


    @Override
    public void actualizar(String numeroRevision) {

        controladorActualizarFechaRevision actualizarFechaRevision = new controladorActualizarFechaRevision();  

        actualizarFechaRevision.tomarDatos(numeroRevision);
        
    }
}
