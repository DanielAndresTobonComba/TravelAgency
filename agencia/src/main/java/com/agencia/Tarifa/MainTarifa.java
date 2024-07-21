package com.agencia.Tarifa;

import com.agencia.Aeropuerto.Application.consultarAeropuerto;
import com.agencia.Tarifa.Adapter.In.controladorAgregarTarifa;
import com.agencia.Tarifa.Adapter.In.controladorConsultarTarifa;
import com.agencia.Tarifa.Adapter.In.controladorEliminarTarifa;
import com.agencia.Tarifa.Adapter.In.ActualizarTarifa.menuActualizarTarifa;
import com.agencia.Tarifa.Adapter.Out.repoAgregarTarifa;
import com.agencia.Tarifa.Adapter.Out.repoConsultarTarifa;
import com.agencia.Tarifa.Adapter.Out.repoEliminarTarifa;
import com.agencia.Tarifa.Application.Casos.agregarTarifa;
import com.agencia.Tarifa.Application.Casos.consultarTarifa;
import com.agencia.Tarifa.Application.Casos.eliminarTarifa;
import com.agencia.Tarifa.Application.Service.InterfazAgregarTarifa;
import com.agencia.Tarifa.Application.Service.InterfazConsultaTarifa;
import com.agencia.Tarifa.Application.Service.InterfazEliminaTarifa;

public class MainTarifa {

    public static void main(String[] args) {
        

/*         InterfazAgregarTarifa servicio = new repoAgregarTarifa();

        agregarTarifa agregarTarifa = new agregarTarifa(servicio); 

        controladorAgregarTarifa adapter = new controladorAgregarTarifa(agregarTarifa);

        adapter.tomarDatosTarifa(); */

/* 
        InterfazConsultaTarifa servicio = new repoConsultarTarifa(); 

        consultarTarifa consultarTarifa = new consultarTarifa(servicio);

        controladorConsultarTarifa adapter = new controladorConsultarTarifa(consultarTarifa);


        adapter.tomarNumeroTarifa();
 */

/*         menuActualizarTarifa menuActualizarTarifa = new menuActualizarTarifa(); 
        menuActualizarTarifa.ejecutarMenu(); */


        InterfazEliminaTarifa servicio = new repoEliminarTarifa();
        

        eliminarTarifa eliminarTarifa = new eliminarTarifa(servicio);

        controladorEliminarTarifa adapter = new controladorEliminarTarifa(eliminarTarifa); 

        adapter.ejecutarEliminarTarifa();
        
    }

}
