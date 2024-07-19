package com.agencia.IntroView.Adapter.In;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Verifiers.CheckInt;

public class Intro {

    public List<Funcionalidad> lstFuncionesIntro;



    public Intro(List<Funcionalidad> lstFuncionesIntro) {
        this.lstFuncionesIntro = lstFuncionesIntro;

        
    }



    public  void start() {
        int opcion = 0;
        boolean checkOpcion = false;

        System.out.println("\n------------------------------");
        System.out.println("   T R A V E L  A G E N C Y");
        System.out.println("==============================");
        System.out.println("            Menú");
        System.out.println("==============================");

        for (Funcionalidad funcionIntro : this.lstFuncionesIntro) {
            int numItem = lstFuncionesIntro.indexOf(funcionIntro) + 1;
            System.out.println(numItem + ". " + funcionIntro.enunciado + "\n");
        }

        System.out.println("------------------------------");

        System.out.println("\n\n. . . . . . . . . .");
        System.out.println("¿Qué deseas realizar?");
        System.out.println(". . . . . . . . . . ");
        System.out.print(">>> ");

        while (checkOpcion == false) {
            opcion = CheckInt.check("Ingrese nuevamente la opción") - 1;

            if (opcion >= lstFuncionesIntro.size() || opcion <= -1 ) {
                System.out.println("\n***********************");
                System.out.println("   OPCIÓN INCORRECTA");
                System.out.println("***********************");

                System.out.println("\n. . . . . . . . . . . . . . . . . .");
                System.out.println("Nuevamente: ¿Qué deseas realizar?");
                System.out.println(". . . . . . . . . . . . . . . . . .");
                System.out.print(">>> ");
            } else {
                checkOpcion = true;
            }

        }

        

        lstFuncionesIntro.get(opcion).ejecutar(null);

    } 

}
