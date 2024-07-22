package com.agencia.RevisionMantenimiento.Adapter.In;
import java.util.List;
import java.util.Scanner;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RevisionMantenimiento.MainRevisionMantenimiento;
import com.agencia.Verifiers.CheckInt;


public class menuRevision {

    public static void ejecutarMenu (Empleado empleado) {

            Scanner sc = new Scanner(System.in);
            int opcion = 0;
            boolean checkOption = false;


            try {

                System.out.println("MENU REVISION MANTENIMIENTO");
        
                List<Funcionalidad> lista = CasesListController.getController().lstFuncionalidadRevisionMantenimiento;

    
                int item = 1;
                for (Funcionalidad atributo : lista) {
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
                    lista.get(opcion - 1).ejecutar(empleado);
                } else {
                    //MainTarifa.main(null); // Llama al método main del Main para volver al menú principal
                }
                
            } 
            

            catch (Exception e) {


                System.out.println("Error al momento de buscar el avion...");
                System.out.println("Presiona Enter para volver al menú");
                sc.nextLine();
                MainRevisionMantenimiento.main(null);
            } 

    }

}
