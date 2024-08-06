package com.agencia.TipoDocumento.Application.Actualizar;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Domain.Service.interfazActualizarTipoDocumento;

public class actualizarNombreTipoDocumento {

    private final interfazActualizarTipoDocumento servicio ;

    public actualizarNombreTipoDocumento(interfazActualizarTipoDocumento servicio) {
        this.servicio = servicio;
    }

    public void ejecutarActualizarTipoDocumento (int numeroTipoDocumento , String nuevoNombre , Empleado empleado) {

        servicio.actualizarTipoDocumento(numeroTipoDocumento , nuevoNombre , empleado);
    }
}
