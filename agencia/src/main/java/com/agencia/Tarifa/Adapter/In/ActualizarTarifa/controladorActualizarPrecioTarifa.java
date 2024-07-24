package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import java.util.Scanner;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarPrecio;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarPrecioTarifa {

    public void tomarPrecio (String numeroTarifa , Empleado empleado) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digita el nuevo precio con este formato (0.0)");
        String nuevoPrecio = CheckString.check("Digita de nuevo el precio"); 

        repoActualizarPrecio repoActualizarPrecio = new repoActualizarPrecio(); 
        repoActualizarPrecio.ejecutarActualizarPrecio(numeroTarifa , nuevoPrecio , empleado);

        
        System.out.println("Presiona enter para volver al menu.......");
        sc.nextLine();
        MainTarifa.main(empleado);
    }

}
