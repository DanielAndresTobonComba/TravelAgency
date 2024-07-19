package com.agencia.EmployeeView.Adapter.In;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.EmployeeView.Application.GeneratedMenu;
import com.agencia.IntroView.Adapter.In.Intro;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckInt;

public class EmployeeView {

    private Empleado empleado;
    private GeneratedMenu generatedMenu;

    public EmployeeView(Empleado empleado, GeneratedMenu generatedMenu) {
        this.empleado = empleado;
        this.generatedMenu = generatedMenu;
    }

    public void generateView() {

        List<Funcionalidad> listEmployeeFunctions = this.generatedMenu.generate(this.empleado.getRol());
        int itemFunction = 0;
        int markedOption = 0;
        boolean correctOption = false;
        List<Funcionalidad> listaFuncionesIntro = CasesListController.getController().lstIntro;

        if (listEmployeeFunctions.size() == 0) {

            System.out.println("\n********************************************");
            System.out.println("  NO HAY FUNCIONES DISPONIBLES PARA TU ROL");
            System.out.println("********************************************");


        } else {

            System.out.println("\n----------------------------------");
            System.out.println("     T R A V E L  A G E N C Y");
            System.out.println("__________________________________\n");
            System.out.println(String.format("  %s",empleado.getUsuario()));
            System.out.println(String.format("  %s",empleado.getName()));
            System.out.println(String.format("  %s",empleado.getRol()));
            System.out.println("__________________________________");
            for(Funcionalidad function : listEmployeeFunctions) {
                itemFunction = listEmployeeFunctions.indexOf(function) + 1;
                System.out.println(itemFunction + ". " + function.enunciado + "\n");
            }
            itemFunction ++;
            System.out.println(itemFunction + ". Cerrar Sesión");
            System.out.println("----------------------------------");

            while ( correctOption == false) {

                System.out.println("\n  Marque la opción del menú");
                System.out.println(". . . . . . . . . . . . . . . .");
                System.out.print(">>> ");
                markedOption = CheckInt.check("Ingrese la opción nuevamente") - 1;

                if (markedOption <= listEmployeeFunctions.size() && markedOption >= 0) {
                    correctOption = true;
                } else {
                    System.out.println("\n*********************");
                    System.out.println("  OPCIÓN INCORRECTA");
                    System.out.println("*********************");
                }   
            
            }

            if (markedOption == listEmployeeFunctions.size()) {
                System.out.println("\n-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                System.out.println(String.format("  %s has cerrado sesión!", empleado.getUsuario()));
                System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
                Intro intro = new Intro(listaFuncionesIntro);
                intro.start();
            } else {
                listEmployeeFunctions.get(markedOption).ejecutar(empleado);
            }

            
            
        }

        
        
        
    }



    



}
