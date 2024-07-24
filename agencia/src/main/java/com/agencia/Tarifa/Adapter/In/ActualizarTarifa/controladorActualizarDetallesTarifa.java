package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import java.util.Scanner;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarDetalle;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarDetallesTarifa {

    public void tomarDatalle (String numeroTarifa , Empleado empleado) {

        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digita el nuevo detalle");
        String descripcion = CheckString.check("Digita de nuevo el detalle"); 

        repoActualizarDetalle repoActualizarDetalle = new repoActualizarDetalle();
        repoActualizarDetalle.ejecutarActualizarDetalle(numeroTarifa, descripcion , empleado);
        
        System.out.println("Presiona enter para volver al menu");
        sc.nextLine();
        MainTarifa.main(empleado);
    }

}
