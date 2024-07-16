package com.agencia.Main;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.Application.crearAeropuerto;
import com.agencia.Aeropuerto.Domain.Entity.Aeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazCrearAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorCrearAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioCrearAeropuerto;
import com.agencia.CasesListController.CasesListController;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.IntroView.Adapter.In.Intro;

public class Main {
    public static void main(String[] args) {
        
        //Confirmación de la conexión a la Base de datos 
        System.out.println(DataBaseConfig.getConnection().msjConnection);

        // Lanzar la aplicación
        List<Funcionalidad> listaFuncionesIntro = CasesListController.getController().lstIntro;
        Intro intro = new Intro(listaFuncionesIntro);

        if (DataBaseConfig.getConnection().verifyConnection) {
            intro.start();
        }
        
        


        interfazCrearAeropuerto servicio = new repositorioCrearAeropuerto();

        crearAeropuerto crearAeropuerto = new crearAeropuerto(servicio);

        controladorCrearAeropuerto adaptador = new controladorCrearAeropuerto(crearAeropuerto);

        //adaptador.tomarDatosAeropuerto();
    }
}