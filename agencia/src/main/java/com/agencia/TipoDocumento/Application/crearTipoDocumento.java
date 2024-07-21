package com.agencia.TipoDocumento.Application;

import com.agencia.TipoDocumento.Domain.Entity.TipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazCrearTipoDocumento;

public class crearTipoDocumento {


    private final interfazCrearTipoDocumento servicio ;

    public crearTipoDocumento(interfazCrearTipoDocumento servicio) {
        this.servicio = servicio;
    } 

    public void tomarDatosTipoDocumento (TipoDocumento entidadDocumento) {
        servicio.crearTipoDocumento(entidadDocumento);
    }
}
