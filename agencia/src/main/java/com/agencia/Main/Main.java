package com.agencia.Main;

import com.agencia.Aeropuerto.Application.actualizarAeropuerto;
import com.agencia.Aeropuerto.Application.consultarAeropuerto;
import com.agencia.Aeropuerto.Application.crearAeropuerto;
import com.agencia.Aeropuerto.Application.eliminarAeropuerto;
import com.agencia.Aeropuerto.Domain.Entity.Aeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazActualizarAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazConsultarAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazCrearAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazEliminarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorActualizarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorConsultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorCrearAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorEliminarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioActualizarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioConsultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioCrearAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioEliminarAeropuerto;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class Main {
    public static void main(String[] args) {
        
        //Confirmación de la conexión a la Base de datos 
/*         System.out.println(DataBaseConfig.getConnection().msjConnection);

        interfazCrearAeropuerto servicio = new repositorioCrearAeropuerto();

        crearAeropuerto crearAeropuerto = new crearAeropuerto(servicio);

        controladorCrearAeropuerto adaptador = new controladorCrearAeropuerto(crearAeropuerto);

        adaptador.tomarDatosAeropuerto(); 
 */

        
/*          interfazEliminarAeropuerto servicio = new repositorioEliminarAeropuerto();

        eliminarAeropuerto eliminarAeropuerto = new eliminarAeropuerto(servicio);

        controladorEliminarAeropuerto adaptador = new controladorEliminarAeropuerto(eliminarAeropuerto);

        adaptador.tomarNumAeropuerto(); */


/*         
        interfazConsultarAeropuerto servicio = new repositorioConsultarAeropuerto(); 

        consultarAeropuerto consultarAeropuerto = new consultarAeropuerto(servicio); 

        controladorConsultarAeropuerto adapter = new controladorConsultarAeropuerto(consultarAeropuerto);

        adapter.tomarNumAeropuerto(); */



        interfazActualizarAeropuerto servicio = new repositorioActualizarAeropuerto(); 

        actualizarAeropuerto actualizarAeropuerto = new actualizarAeropuerto(servicio);

        controladorActualizarAeropuerto consultarAeropuerto = new controladorActualizarAeropuerto(actualizarAeropuerto);

        consultarAeropuerto.actualizarAeropuerto();









    }
}