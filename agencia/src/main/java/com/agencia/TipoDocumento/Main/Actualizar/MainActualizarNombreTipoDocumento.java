package com.agencia.TipoDocumento.Main.Actualizar;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.In.Actualizar.controladorActualizarNombreTipoDocumento;
import com.agencia.TipoDocumento.Adapter.Out.repoActualizarTipoDocumento;
import com.agencia.TipoDocumento.Application.Actualizar.actualizarNombreTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazActualizarTipoDocumento;

public class MainActualizarNombreTipoDocumento {

    public static void main (Empleado empleado) {

        interfazActualizarTipoDocumento servicio = new repoActualizarTipoDocumento(); 

        actualizarNombreTipoDocumento actualizarTipoDocumento = new com.agencia.TipoDocumento.Application.Actualizar.actualizarNombreTipoDocumento(servicio); 

        controladorActualizarNombreTipoDocumento adaptador = new controladorActualizarNombreTipoDocumento(actualizarTipoDocumento); 

        adaptador.tomarDatosTipoDocumento(empleado);
    
    }
}
