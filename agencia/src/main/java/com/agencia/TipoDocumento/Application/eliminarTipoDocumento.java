package com.agencia.TipoDocumento.Application;

import com.agencia.Aeropuerto.Domain.Service.interfazEliminarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Domain.Entity.TipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazCrearTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazEliminarTipoDocumento;

public class eliminarTipoDocumento {


    private final interfazEliminarTipoDocumento servicio ;

    public eliminarTipoDocumento(interfazEliminarTipoDocumento servicio) {
        this.servicio = servicio;
    } 

    public void ejecutarELiminarTipoDocumento (int numeroTIpoDocumento , Empleado empleado) {
        servicio.eliminarTipoDocumento(numeroTIpoDocumento , empleado);
    }

}
