package com.agencia.Main;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
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
        
        intro.start();



    }
}