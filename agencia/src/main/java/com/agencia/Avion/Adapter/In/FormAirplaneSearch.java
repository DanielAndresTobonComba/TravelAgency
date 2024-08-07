package com.agencia.Avion.Adapter.In;

import java.sql.ResultSet;
import java.util.List;

import com.agencia.Avion.Application.ExistentPlatesExtraction;
import com.agencia.Avion.Application.ExtractSearchAirplaneAction;
import com.agencia.Avion.Application.ViewSearchAirplaneAction;
import com.agencia.Avion.Main.MainMenuGestionAvion;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Verifiers.CheckString;

public class FormAirplaneSearch {

    private ExistentPlatesExtraction existentPlatesExtraction;
    private ExtractSearchAirplaneAction extractSearchAirplaneAction;
    private ViewSearchAirplaneAction viewSearchAirplaneAction;

    

    public FormAirplaneSearch(ExistentPlatesExtraction existentPlatesExtraction,
            ExtractSearchAirplaneAction extractSearchAirplaneAction,
            ViewSearchAirplaneAction viewSearchAirplaneAction) {
        this.existentPlatesExtraction = existentPlatesExtraction;
        this.extractSearchAirplaneAction = extractSearchAirplaneAction;
        this.viewSearchAirplaneAction = viewSearchAirplaneAction;
    }



    public void search(Empleado empleado) {

        List<String> listRegisteredPlates = this.existentPlatesExtraction.executeExtract(); 
        ResultSet infoAirplane = null;
        boolean checkPlaca = false;
        boolean exitPlaca = false;
        String placa = "";


        System.out.println("\n________________________\n");
        System.out.println("     CONSULTAR AVIÓN");
        System.out.println("__________________________\n");

        // Registro de la placa

        while (exitPlaca == false) {

            System.out.println("\n\n--> Ingrese la placa del Avión");
            System.out.println("....................................");
            System.out.println("      [EXIT/exit] para Salir");
            System.out.print(">>> ");

            placa = CheckString.check("Ingrese la placa nuevamente");

            if (placa.toLowerCase().trim().equals("exit")) {

                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x      CONSULTA CANCELADA      x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
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

            infoAirplane = this.extractSearchAirplaneAction.extract(placa);

            this.viewSearchAirplaneAction.view(infoAirplane);

            MainMenuGestionAvion.main(empleado);



        }

    }

}
