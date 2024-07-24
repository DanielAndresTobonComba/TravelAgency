package com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos;

import java.util.Scanner;

import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Adapter.Out.existeAvion;
import com.agencia.RevisionMantenimiento.Adapter.Out.ActualizarRevision.repoActualizarAvion;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarAvion {

    public void tomarDatos (String numeroRevision) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("    ACTUALIZAR AVION");
        System.out.println("===================================\n");

       System.out.print("Placa del aviòn >>>>");
       String placa = CheckString.check("Digita de nuevo la placa"); 
       
       existeAvion existeAvion = new existeAvion(); 
       

       if(existeAvion.verficiar(placa)) {

        repoActualizarAvion actualizarAvion = new repoActualizarAvion(); 
        actualizarAvion.ejecutarActualizarAvion(numeroRevision , placa);
        
       } else {
        System.out.println("Error al buscar la placa");
        System.out.println("Presiona enter para volver al menu");
        sc.nextLine();
        MainRevisionMantenimiento.main();

       }








    }

}
