package com.agencia.Aeropuerto.Infraestructure.In;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.EmployeeView.MainEmployeeView.MainEmployeeView;
import com.agencia.IntroView.Adapter.In.Intro;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckInt;

public class IntroGestionAeropuerto {

    private List<Funcionalidad> listaFuncionesGestionarAeropuerto;
    private Empleado empleado;

    

    public IntroGestionAeropuerto(List<Funcionalidad> listaFuncionesGestionarAeropuerto, Empleado empleado) {
        this.listaFuncionesGestionarAeropuerto = listaFuncionesGestionarAeropuerto;
        this.empleado = empleado;
    }



    public void start() {

        int itemFunction = 0;
        int markedOption = 0;
        boolean correctOption = false;
        List<Funcionalidad> listaFuncionesGestionarAeropuerto = this.listaFuncionesGestionarAeropuerto;
        Empleado empleado = this.empleado;


        System.out.println("\n----------------------------------");
        System.out.println("     T R A V E L  A G E N C Y");
        System.out.println("__________________________________\n");
        System.out.println(String.format("  User: %s",this.empleado.getUsuario()));
        System.out.println(String.format("  Nombre: %s", this.empleado.getName()));
        System.out.println(String.format("  Rol: %s", this.empleado.getRol()));
        System.out.println("__________________________________");
        System.out.println("       GESTIONAR AEROPUERTO");
        System.out.println("===================================");

        for(Funcionalidad function : listaFuncionesGestionarAeropuerto) {
            itemFunction = listaFuncionesGestionarAeropuerto.indexOf(function) + 1;
            System.out.println("   " + itemFunction + ". " + function.enunciado + "\n");
        }
        itemFunction ++;
        System.out.println("   " + itemFunction + ". Salir");
        System.out.println("----------------------------------");

        while ( correctOption == false) {

                System.out.println("\n  Marque la opción del menú");
                System.out.println(". . . . . . . . . . . . . . . .");
                System.out.print(">>> ");
                markedOption = CheckInt.check("Ingrese la opción nuevamente") - 1;

                if (markedOption <= listaFuncionesGestionarAeropuerto.size() && markedOption >= 0) {
                    correctOption = true;
                } else {
                    System.out.println("\n*********************");
                    System.out.println("  OPCIÓN INCORRECTA");
                    System.out.println("*********************");
                }   
            
        }

        if (markedOption == listaFuncionesGestionarAeropuerto.size()) {
                MainEmployeeView.mainEmployeeView(empleado);
            } else {
                listaFuncionesGestionarAeropuerto.get(markedOption).ejecutar(empleado);
            }




    }

}
