package com.agencia.Tarifa.Adapter.In;

import java.util.Scanner;

import com.agencia.Avion.Main.MainMenuGestionAvion;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.repoAgregarTarifa;
import com.agencia.Tarifa.Domain.Tarifa;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckDecimal;
import com.agencia.Verifiers.CheckString;

public class controladorAgregarTarifa { 


/*    private final agregarTarifa servicioAgregarTarifa; 

    

    public controladorAgregarTarifa(agregarTarifa servicioAgregarTarifa) {
        this.servicioAgregarTarifa = servicioAgregarTarifa;
    }  */



    public static void tomarDatosTarifa (Empleado empleado) {

        Tarifa tarifa = new Tarifa(); 
        boolean exitDescripcion = false;
        boolean checkDescripcion = false;
        String descripcion = "";

        System.out.println("\n_______________________\n");
        System.out.println("     AGREGAR TARIFA");
        System.out.println("________________________\n");


        while (exitDescripcion == false) {

            System.out.println("\n\n--> Ingrese la descripcion de la tarifa");
            System.out.println(".............................................");
            System.out.println("           [EXIT/exit] para Salir");
            System.out.print(">>> ");

            descripcion = CheckString.check("Ingrese la descripcion nuevamente");

            if (descripcion.toLowerCase().trim().equals("exit")) {

                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x    REGISTRO CANCELADO   x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                exitDescripcion = true;
                MainTarifa.main(empleado);



            } else {

                exitDescripcion = true;
                checkDescripcion = true;
                
               
            }
            
        }

        Scanner sc = new Scanner(System.in);


        

        System.out.println("Digita una descripcion resumida ");
        //String descripcion = sc.nextLine();

        
        System.out.println("Digite detalles de la tarifa ");
        String detalles = CheckString.check("Digite de nuevo los detalles ");

        System.out.println("Digita el precio base");
        Double precioBase = CheckDecimal.check("Digita de nuevo el precio base");



        System.out.println("Digita el impuesto en decimal");
        Double impuesto = CheckDecimal.check("Digita de nuevo el impuesto");


        tarifa.setDescripcion(descripcion);
        tarifa.setDetalle(detalles);
        tarifa.setPrecioBase(precioBase);
        tarifa.setImpuesto(impuesto);

        repoAgregarTarifa repoAgregarTarifa = new repoAgregarTarifa();

        repoAgregarTarifa.agregar(tarifa);

    

        MainTarifa.main(empleado);
 


        
    }

}
