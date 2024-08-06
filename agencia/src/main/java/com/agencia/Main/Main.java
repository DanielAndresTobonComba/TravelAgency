package com.agencia.Main;

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
import com.agencia.CasesListController.CasesListController;
import com.agencia.IntroView.Adapter.In.Intro;
import com.agencia.DataBaseConfig.DataBaseConfig;

public class Main {


    public static void main(String[] args) {
        
         //Confirmación de la conexión a la Base de datos 

         System.out.println( DataBaseConfig.getConnection().msjConnection );

        // Lanzar la aplicación
        List<Funcionalidad> listaFuncionesIntro = CasesListController.getController().lstIntro;
        Intro intro = new Intro(listaFuncionesIntro);

        if (DataBaseConfig.getConnection().verifyConnection) {
            intro.start();
        } 

        

     
    }
}