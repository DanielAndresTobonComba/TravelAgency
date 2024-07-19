package com.agencia.TipoDocumento;

import com.agencia.Cliente.Adapter.In.controladorCrearCliente;
import com.agencia.TipoDocumento.Adapter.In.controladorActualizarTipoDocumento;
import com.agencia.TipoDocumento.Adapter.In.controladorCrearTipoDocumento;
import com.agencia.TipoDocumento.Adapter.In.controladorEliminarTipoDocumento;
import com.agencia.TipoDocumento.Adapter.Out.repoActualizarTipoDocumento;
import com.agencia.TipoDocumento.Adapter.Out.repoCrearTipoDocumento;
import com.agencia.TipoDocumento.Adapter.Out.repoEliminarTipoDocumento;
import com.agencia.TipoDocumento.Application.actualizarTipoDocumento;
import com.agencia.TipoDocumento.Application.crearTipoDocumento;
import com.agencia.TipoDocumento.Application.eliminarTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazActualizarTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazCrearTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazEliminarTipoDocumento;

public class MainTipoDocumento {

    public static void main(String[] args) {

/*      interfazActualizarTipoDocumento servicio = new repoActualizarTipoDocumento(); 

        actualizarTipoDocumento actualizarTipoDocumento = new com.agencia.TipoDocumento.Application.actualizarTipoDocumento(servicio); 

        controladorActualizarTipoDocumento adaptador = new controladorActualizarTipoDocumento(actualizarTipoDocumento); 


        adaptador.tomarDatosTipoDocumento(); */


/* 
        interfazCrearTipoDocumento servicio = new repoCrearTipoDocumento(); 

        crearTipoDocumento crearTipoDocumento = new crearTipoDocumento(servicio);

        controladorCrearTipoDocumento adaptador = new controladorCrearTipoDocumento(crearTipoDocumento);

        adaptador.tomarDatos(); */


        interfazEliminarTipoDocumento servicio = new repoEliminarTipoDocumento(); 

        eliminarTipoDocumento eliminarTipoDocumento = new eliminarTipoDocumento(servicio); 

        controladorEliminarTipoDocumento adaptador = new controladorEliminarTipoDocumento(eliminarTipoDocumento);

        adaptador.ejecutarEliminarTipoDocumento(); 





    }

}
