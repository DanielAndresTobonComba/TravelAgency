package com.agencia.Main;

import java.util.ArrayList;
import java.util.Arrays;
/*import com.agencia.Aeropuerto.Application.actualizarAeropuerto;
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
*/
import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
//import com.agencia.Aeropuerto.Application.crearAeropuerto;
//import com.agencia.Aeropuerto.Domain.Entity.Aeropuerto;
//import com.agencia.Aeropuerto.Domain.Service.interfazCrearAeropuerto;
//import com.agencia.Aeropuerto.Infraestructure.In.controladorCrearAeropuerto;
//import com.agencia.Aeropuerto.Infraestructure.Out.repositorioCrearAeropuerto;
import com.agencia.CasesListController.CasesListController;
import com.agencia.Cliente.MainCliente;
//import com.agencia.Cliente.Adapter.In.controladorCrearCliente;
//import com.agencia.Cliente.Adapter.Out.repositorioCrearCliente;
//import com.agencia.Cliente.Application.crearCliente;
//import com.agencia.Cliente.Domian.Service.interfazCrearCliente;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.IntroView.Adapter.In.Intro;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.Verifiers.AvailableChairsList;

public class Main {


    public static void main(String[] args) {
        
/*         //Confirmación de la conexión a la Base de datos 
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[32m";
        //String RED = "\u001B[31m";
        String [] chairsReserved = { "C5", "C2", "C3", "G3", "G2", "L1", "O1", "O2", "O3", "O4", "O5"};
        List<String> listChairsReserved = new ArrayList<>(Arrays.asList(chairsReserved));
        System.out.println(AvailableChairsList.generate(1010, listChairsReserved));
         System.out.println(GREEN + DataBaseConfig.getConnection().msjConnection + RESET);

        // Lanzar la aplicación
        List<Funcionalidad> listaFuncionesIntro = CasesListController.getController().lstIntro;
        Intro intro = new Intro(listaFuncionesIntro);

        if (DataBaseConfig.getConnection().verifyConnection) {
            intro.start();
        } */

        //MainRevisionMantenimiento.main();

        MainCliente.main(args);



    }
}