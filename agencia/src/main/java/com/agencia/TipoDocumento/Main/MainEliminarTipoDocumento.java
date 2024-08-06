package com.agencia.TipoDocumento.Main;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.In.controladorCrearTipoDocumento;
import com.agencia.TipoDocumento.Adapter.In.controladorEliminarTipoDocumento;
import com.agencia.TipoDocumento.Adapter.Out.repoCrearTipoDocumento;
import com.agencia.TipoDocumento.Adapter.Out.repoEliminarTipoDocumento;
import com.agencia.TipoDocumento.Application.crearTipoDocumento;
import com.agencia.TipoDocumento.Application.eliminarTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazCrearTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazEliminarTipoDocumento;

public class MainEliminarTipoDocumento {

    public static void main (Empleado empleado) {

        interfazEliminarTipoDocumento servicio = new repoEliminarTipoDocumento(); 

        eliminarTipoDocumento eliminarTipoDocumento = new eliminarTipoDocumento(servicio); 

        controladorEliminarTipoDocumento adaptador = new controladorEliminarTipoDocumento(eliminarTipoDocumento);

        adaptador.ejecutarEliminarTipoDocumento(empleado); 



    }

}
