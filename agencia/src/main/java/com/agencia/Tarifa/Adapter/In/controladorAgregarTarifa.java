package com.agencia.Tarifa.Adapter.In;

import java.util.Scanner;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.repoAgregarTarifa;
import com.agencia.Tarifa.Application.Casos.agregarTarifa;
import com.agencia.Tarifa.Domain.Tarifa;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckDecimal;
import com.agencia.Verifiers.CheckString;

public class controladorAgregarTarifa { 

/*     private final agregarTarifa servicioAgregarTarifa; 

    

    public controladorAgregarTarifa(agregarTarifa servicioAgregarTarifa) {
        this.servicioAgregarTarifa = servicioAgregarTarifa;
    } */



    public static void tomarDatosTarifa (Empleado empleado) {

        Scanner sc = new Scanner(System.in);


        Tarifa tarifa = new Tarifa(); 

        System.out.println("Digita una descripcion resumida (Opcional)");
        String descripcion = sc.nextLine();

        
        System.out.println("Digite detalles de la tarifa");
        String detalles = CheckString.check("Digite de nuevo los detalles");

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
