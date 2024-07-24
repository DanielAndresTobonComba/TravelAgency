package com.agencia.Main;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.DataBaseConfig.DataBaseConfig;
import com.agencia.IntroView.Adapter.In.Intro;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.Tarifa.MainTarifa.MainTarifa;

public class Main {


    public static void main(String[] args) {
        
      //Confirmación de la conexión a la Base de datos 
        String RESET = "\u001B[0m";
        String GREEN = "\u001B[42m";
         System.out.println(GREEN + DataBaseConfig.getConnection().msjConnection + RESET);

        // Lanzar la aplicación
        List<Funcionalidad> listaFuncionesIntro = CasesListController.getController().lstIntro;
        Intro intro = new Intro(listaFuncionesIntro);

        if (DataBaseConfig.getConnection().verifyConnection) {
            intro.start();
        } 

        //MainRevisionMantenimiento.main();

        //MainCliente.main(args);

        //MainRevisionMantenimiento.main();

     
    }
}