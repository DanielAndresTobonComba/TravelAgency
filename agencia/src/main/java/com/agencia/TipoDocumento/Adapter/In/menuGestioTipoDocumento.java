package com.agencia.TipoDocumento.Adapter.In;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.AbstractClasses.subFuncionalidad;
import com.agencia.EmployeeView.MainEmployeeView.MainEmployeeView;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckInt;

public class menuGestioTipoDocumento {

    private List<subFuncionalidad> listaFuncionesTipoDocumento;
    private Empleado empleado;

    

    public menuGestioTipoDocumento(List<subFuncionalidad> listaFuncionesTipoDocumento, Empleado empleado) {
        this.listaFuncionesTipoDocumento = listaFuncionesTipoDocumento;
        this.empleado = empleado;
    }



    public void start() {

        int itemFunction = 0;
        int markedOption = 0;
        boolean correctOption = false;
        List<subFuncionalidad> listaFuncionesTipoDocumento = this.listaFuncionesTipoDocumento;
        Empleado empleado = this.empleado;


        System.out.println("\n----------------------------------");
        System.out.println("     T R A V E L  A G E N C Y");
        System.out.println("__________________________________\n");
        System.out.println(String.format("  User: %s",this.empleado.getUsuario()));
        System.out.println(String.format("  Nombre: %s", this.empleado.getName()));
        System.out.println(String.format("  Rol: %s", this.empleado.getRol()));
        System.out.println("__________________________________");
        System.out.println("       GESTIONAR TIPO DOCUMENTO");
        System.out.println("===================================");

        for(subFuncionalidad function : listaFuncionesTipoDocumento) {
            itemFunction = listaFuncionesTipoDocumento.indexOf(function) + 1;
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

                if (markedOption <= listaFuncionesTipoDocumento.size() && markedOption >= 0) {
                    correctOption = true;
                } else {
                    System.out.println("\n*********************");
                    System.out.println("  OPCIÓN INCORRECTA");
                    System.out.println("*********************");
                }   
            
        }

        if (markedOption == listaFuncionesTipoDocumento.size()) {
                MainEmployeeView.mainEmployeeView(empleado);
            } else {
                listaFuncionesTipoDocumento.get(markedOption).ejecutar(empleado);
            }




    }
}
