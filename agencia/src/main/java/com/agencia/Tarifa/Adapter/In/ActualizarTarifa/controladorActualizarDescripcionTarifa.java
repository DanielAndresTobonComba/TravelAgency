package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import java.util.Scanner;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarDescripcion;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarDescripcionTarifa {

    public void tomarDatos (String numeroTarifa , Empleado empleado) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digita la nueva descripción ");
        String descripcion = CheckString.check("Digita de nuevo la descripción"); 

        repoActualizarDescripcion repoActualizarDescripcion = new repoActualizarDescripcion(); 
        repoActualizarDescripcion.ejecutarActualizarDescripcion(numeroTarifa , descripcion , empleado);

        System.out.println("Presiona enter para volver al menu.......");
        sc.nextLine();
        MainTarifa.main(empleado);
        
    }

}
