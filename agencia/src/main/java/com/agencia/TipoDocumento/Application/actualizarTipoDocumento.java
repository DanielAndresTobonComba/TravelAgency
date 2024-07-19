package com.agencia.TipoDocumento.Application;

import com.agencia.TipoDocumento.Domain.Service.interfazActualizarTipoDocumento;

public class actualizarTipoDocumento {

    private final interfazActualizarTipoDocumento servicio ;

    public actualizarTipoDocumento(interfazActualizarTipoDocumento servicio) {
        this.servicio = servicio;
    }

    public void ejecutarActualizarTipoDocumento (int numeroTipoDocumento , String nuevoNombre) {

        servicio.actualizarTipoDocumento(numeroTipoDocumento , nuevoNombre);
    }
}
