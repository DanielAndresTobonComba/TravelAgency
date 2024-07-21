package com.agencia.EliminarAvion.Adapter.In;

import java.util.List;

import com.agencia.EliminarAvion.Application.DeleteAirplaneAction;
import com.agencia.EmployeeView.MainEmployeeView.MainEmployeeView;
import com.agencia.GestionAvion.Main.MainMenuGestionAvion;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.Verifiers.CheckString;

public class FormAirplaneDeletion {

    private ExistentPlatesExtraction existentPlatesExtraction;
    private DeleteAirplaneAction deleteAirplaneAction;

    public FormAirplaneDeletion(ExistentPlatesExtraction existentPlatesExtraction, DeleteAirplaneAction deleteAirplaneAction) {
        this.existentPlatesExtraction = existentPlatesExtraction;
        this.deleteAirplaneAction = deleteAirplaneAction;
    }

    public void delete(Empleado empleado) {

        List<String> listRegisteredPlates = this.existentPlatesExtraction.executeExtract(); 
        boolean checkPlaca = false;
        boolean exitPlaca = false;
        String placa = "";
        boolean checkDelete = false;


        System.out.println("\n_______________________\n");
        System.out.println("     ELIMINAR AVIÓN");
        System.out.println("________________________\n");

        // Registro de la placa

        while (exitPlaca == false) {

            System.out.println("\n\n--> Ingrese la placa del Avión");
            System.out.println("....................................");
            System.out.println("      [EXIT/exit] para Salir");
            System.out.print(">>> ");

            placa = CheckString.check("Ingrese la placa nuevamente");

            if (placa.toLowerCase().trim().equals("exit")) {

                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x    ELIMINACIÓN CANCELADA    x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxX");
                exitPlaca = true;
                MainMenuGestionAvion.main(empleado);



            } else {
                
                if (listRegisteredPlates.contains(placa) == false) {

                    System.out.println("\n********************************************");
                    System.out.println("*              NO ES POSIBLE               *");
                    System.out.println("*------------------------------------------*");
                    System.out.println("*  Esta placa NO se encuentra registrada   *");
                    System.out.println("********************************************\n");

                } else {

                    exitPlaca = true;
                    checkPlaca = true;

                }

                //checkPlaca = true;
            }
            
        }

        if (checkPlaca == true) {

            checkDelete = this.deleteAirplaneAction.executeDeletion(placa);

            if (checkDelete == true) {

                System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                System.out.println("   Avión eliminado EXITOSAMENTE");
                System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                MainMenuGestionAvion.main(empleado);

            } else {

                System.out.println("\n\n-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
                System.out.println("   ERROR! No fue posible eliminar el Avión");
                System.out.println("-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
                MainMenuGestionAvion.main(empleado);

            }

        }


    }

}
