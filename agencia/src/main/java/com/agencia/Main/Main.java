package com.agencia.Main;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.IntroView.Adapter.In.Intro;

import Aeropuerto.Application.crearAeropuerto;
import Aeropuerto.Domain.Entity.Aeropuerto;
import Aeropuerto.Domain.Service.interfazCrearAeropuerto;
import Aeropuerto.Infraestructure.In.controladorCrearAeropuerto;
import Aeropuerto.Infraestructure.Out.repositorioCrearAeropuerto;

public class Main {
    public static void main(String[] args) {
        
        //Confirmación de la conexión a la Base de datos 
        System.out.println(DataBaseConfig.getConnection().msjConnection);

        // Lanzar la aplicación
        List<Funcionalidad> listaFuncionesIntro = CasesListController.getController().lstIntro;
        Intro intro = new Intro(listaFuncionesIntro);
        
        intro.start();


        interfazCrearAeropuerto servicio = new repositorioCrearAeropuerto();

        crearAeropuerto crearAeropuerto = new crearAeropuerto(servicio);

        controladorCrearAeropuerto adaptador = new controladorCrearAeropuerto(crearAeropuerto);

        adaptador.tomarDatosAeropuerto();
    }
}