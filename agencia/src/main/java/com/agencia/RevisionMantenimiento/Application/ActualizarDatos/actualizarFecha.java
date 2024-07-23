package com.agencia.RevisionMantenimiento.Application.ActualizarDatos;

import com.agencia.RevisionMantenimiento.Domain.actualizarDatosRevision;

public class actualizarFecha extends actualizarDatosRevision {


    public actualizarFecha(String enunciado) {
        this.enunciado = enunciado;
    }


    @Override
    public void actualizar(String numeroRevision) {
        
    }
}
