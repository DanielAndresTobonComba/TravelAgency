package com.agencia.RevisionMantenimiento.Adapter.In.ActualizarDatos;

import java.util.List;
import java.util.Scanner;

import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.RevisionMantenimiento.Adapter.Out.existeRevision;
import com.agencia.RevisionMantenimiento.Domain.actualizarDatosRevision;
import com.agencia.Tarifa.MainTarifa;


import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class menuActualizarRevision {

    public void ejecutarMenu (Empleado empleado) { 


            Scanner sc = new Scanner(System.in);
            int opcion = 0;
            boolean checkOption = false;

            try {
                System.out.println("Ingresa el numero de revisión");
                String numeroRevision = CheckString.check("Digita el numero de nuevo");
        
                existeRevision existeRevision = new existeRevision();
        
                List<actualizarDatosRevision> lista = CasesListController.getController().lstActualizarDatosRevisionMantenimiento;

                if (!existeRevision.verficiar(numeroRevision)) {
                    System.out.println("Presiona Enter para volver al menú");
                    sc.nextLine();
                    MainRevisionMantenimiento.main(); // Llama al método main del Main para volver al menú principal
                    return;
                }


                System.out.println("MENU DE ACTUALIZACIÓN");
    
                int item = 1;
                for (actualizarDatosRevision atributo : lista) {
                    System.out.println(item + ". " + atributo.enunciado + "\n");
                    item++;
                }
        
                System.out.println(item + ". " + "Salir");
        
    
        
                while (!checkOption) {
                    opcion = CheckInt.check("Digita de nuevo la opcion");
                    if (opcion >= 1 && opcion <= lista.size() + 1) {
                        checkOption = true;
                    } else {
                        System.out.println("Opcion incorrecta");
                    }
                }
        
                if (opcion <= lista.size()) {
                    lista.get(opcion - 1).actualizar(numeroRevision);
                } else {
                    MainRevisionMantenimiento.main(); // Llama al método main del Main para volver al menú principal
                }
                
            } 
            

            catch (Exception e) {


                System.out.println("Error al momento de buscar la revision...");
                System.out.println("Presiona Enter para volver al menú");
                sc.nextLine();
                MainRevisionMantenimiento.main();
            } 

           
    


        }


}

