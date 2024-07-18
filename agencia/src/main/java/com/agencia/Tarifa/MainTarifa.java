package com.agencia.Tarifa;

import com.agencia.Tarifa.Adapter.In.controladorAgregarTarifa;
import com.agencia.Tarifa.Adapter.Out.repoAgregarTarifa;
import com.agencia.Tarifa.Application.Entity.agregarTarifa;
import com.agencia.Tarifa.Application.Service.InterfazAgregarTarifa;

public class MainTarifa {

    public static void main(String[] args) {
        System.out.println("ENTRANDO A MAIN TARIFA");

        InterfazAgregarTarifa servicio = new repoAgregarTarifa();

        agregarTarifa agregarTarifa = new agregarTarifa(servicio); 

        controladorAgregarTarifa adapter = new controladorAgregarTarifa(agregarTarifa);

        adapter.tomarDatosTarifa();


        
    }

}
