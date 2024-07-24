package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import java.util.Scanner;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarDescripcion;
import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarImpuesto;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarImpuestoTarifa {

    public void tomarImpuesto (String numeroTarifa , Empleado empleado) {

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digita el nuevo impuesto con este formato (0.0)");
        String nuevoImpuesto = CheckString.check("Digita de nuevo el impuesto");
        
        repoActualizarImpuesto repoActualizarImpuesto = new repoActualizarImpuesto(); 
        repoActualizarImpuesto.ejecutarActualizarImpuesto( numeroTarifa, nuevoImpuesto ,empleado );

        
        System.out.println("Presiona enter para volver al menu");
        sc.nextLine();
        MainTarifa.main(empleado);
        


    }

}
