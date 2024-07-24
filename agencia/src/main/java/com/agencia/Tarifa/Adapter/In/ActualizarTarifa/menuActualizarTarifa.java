package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import java.util.List;
import java.util.Scanner;

import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.Out.existeTarifa;
import com.agencia.Tarifa.Domain.actualizarDatosTarifa;
import com.agencia.Tarifa.MainTarifa.MainTarifa;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class menuActualizarTarifa {

        public static void ejecutarMenu (Empleado empleado) {

            Scanner sc = new Scanner(System.in);
            int opcion = 0;
            boolean checkOption = false;
            List<actualizarDatosTarifa> lista = CasesListController.getController().lstActualizarDatosTarifas;

            try {

                System.out.println("MENU TARIFA");
                System.out.print("Nùmero de tarifa >>>> ");
                String numeroTarifa = CheckString.check("Digita el numero de nuevo");
        
                existeTarifa existeTarifa = new existeTarifa();
        
                

                if (!existeTarifa.verficiar(numeroTarifa)) {
                    System.out.println("Presiona Enter para volver al menú");
                    sc.nextLine();
                    MainTarifa.main(null); // Llama al método main del Main para volver al menú principal
                    return;
                }


                System.out.println("MENU DE ACTUALIZACIÓN");
    
                int item = 1;
                for (actualizarDatosTarifa atributo : lista) {
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
                    lista.get(opcion - 1).actualizar(numeroTarifa);
                } else {
                    MainTarifa.main(null); // Llama al método main del Main para volver al menú principal
                }
                
            } 
            

            catch (Exception e) {


                System.out.println("Error al momento de buscar la tarifa...");
                System.out.println("Presiona Enter para volver al menú");
                sc.nextLine();
                MainTarifa.main(null);
            } 

           
    


        }

       

}
