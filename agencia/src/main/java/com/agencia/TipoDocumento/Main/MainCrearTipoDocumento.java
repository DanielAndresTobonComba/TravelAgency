package com.agencia.TipoDocumento.Main;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.In.controladorCrearTipoDocumento;
import com.agencia.TipoDocumento.Adapter.Out.repoCrearTipoDocumento;
import com.agencia.TipoDocumento.Application.crearTipoDocumento;
import com.agencia.TipoDocumento.Domain.Service.interfazCrearTipoDocumento;

public class MainCrearTipoDocumento {

        public static void main (Empleado empleado) {

            interfazCrearTipoDocumento servicio = new repoCrearTipoDocumento(); 

            crearTipoDocumento crearTipoDocumento = new crearTipoDocumento(servicio);

            controladorCrearTipoDocumento adaptador = new controladorCrearTipoDocumento(crearTipoDocumento);

            adaptador.tomarDatos(empleado);


         }

         

}
