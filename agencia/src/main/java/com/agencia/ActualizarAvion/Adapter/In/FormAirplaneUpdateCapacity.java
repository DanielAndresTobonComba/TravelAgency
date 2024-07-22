package com.agencia.ActualizarAvion.Adapter.In;

import java.sql.ResultSet;
import java.util.List;

import com.agencia.ActualizarAvion.Application.ExtractAirplaneAction;
import com.agencia.ActualizarAvion.Application.UpdateAirplaneAction;
import com.agencia.ActualizarAvion.MainActualizarAvion.MainActualizarAvion;
import com.agencia.ConsultarAvion.Application.ExtractSearchAirplaneAction;
import com.agencia.ConsultarAvion.Application.ViewSearchAirplaneAction;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Domain.Entity.Airplane;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class FormAirplaneUpdateCapacity {

    private ExistentPlatesExtraction existentPlatesExtraction;
    private UpdateAirplaneAction updateAirplaneAction;
    private ExtractSearchAirplaneAction extractSearchAirplaneAction;
    private ViewSearchAirplaneAction viewSearchAirplaneAction;
    private ExtractAirplaneAction extractAirplaneAction;

    

    public FormAirplaneUpdateCapacity(ExistentPlatesExtraction existentPlatesExtraction,
            UpdateAirplaneAction updateAirplaneAction, ExtractSearchAirplaneAction extractSearchAirplaneAction,
            ViewSearchAirplaneAction viewSearchAirplaneAction, ExtractAirplaneAction extractAirplaneAction) {
        this.existentPlatesExtraction = existentPlatesExtraction;
        this.updateAirplaneAction = updateAirplaneAction;
        this.extractSearchAirplaneAction = extractSearchAirplaneAction;
        this.viewSearchAirplaneAction = viewSearchAirplaneAction;
        this.extractAirplaneAction = extractAirplaneAction;
    }



    public void updateCapacity(Empleado empleado/* , Airplane airplane*/) {

        List<String> listRegisteredPlates = this.existentPlatesExtraction.executeExtract(); 
        ResultSet infoAirplane = null;
        boolean checkPlaca = false;
        boolean exitPlaca = false;
        String placa = "";
        Airplane airplane = null;
        int capacidadBefore = 0;
        int capacidadNew = 0;
        boolean exitCapacidad = false;
        boolean checkCapacidad = false;
        boolean checkCambio = false;


        System.out.println("\n______________________________________\n");
        System.out.println("    ACTUALIZAR CAPACIDAD DE AVIÓN");
        System.out.println("______________________________________\n");

        // Registro de la placa

        while (exitPlaca == false) {

            System.out.println("\n\n--> Ingrese la placa del Avión");
            System.out.println("....................................");
            System.out.println("      [EXIT/exit] para Salir");
            System.out.print(">>> ");

            placa = CheckString.check("Ingrese la placa nuevamente");

            if (placa.toLowerCase().trim().equals("exit")) {

                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x      ACTUALIZACIÓN CANCELADA      x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                exitPlaca = true;
                MainActualizarAvion.main(empleado);



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
            airplane = this.extractAirplaneAction.extract(placa);
            capacidadBefore = airplane.getCapacidad();

            System.out.println("\n\n    Información del Avión");
            System.out.println("   que se desea actualizar");
            System.out.println("- - - - - - - - - - - - - - - -");
            System.out.println("              ||");
            System.out.println("              ||");
            System.out.println("              ||");
            System.out.println("              \\/");

            viewSearchAirplaneAction.view(infoAirplane);

            while ((exitCapacidad == false)) {
                
                System.out.println("\n\n--> Ingrese la capacidad del Avión");
                System.out.println("......................................");
                System.out.println("      (Presiona -1 para Salir)");
                System.out.print(">>> ");

                capacidadNew = CheckInt.check("Ingrese la capacidad nuevamente");

                if (capacidadNew == -1) {

                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x    ACTUALIZACIÓN CANCELADA   x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    exitCapacidad = true;
                    MainActualizarAvion.main(empleado);
    
                } else if (capacidadNew <=0 && capacidadNew != -1) {

                    System.out.println("\n*******************************************");
                    System.out.println("||  LA CAPACIDAD NO PUEDE SER NEGATIVA   ||");
                    System.out.println("*******************************************\n");

                } else if (capacidadBefore == capacidadNew) {

                    System.out.println("\n************************************************");
                    System.out.println("||          ¡ACTUALIZACIÓN CANCELADA!          ||");
                    System.out.println("||    Esta capacidad es igual a la anterior    ||");
                    System.out.println("*************************************************\n");
                    
                } else {

                    exitCapacidad = true;
                    checkCapacidad = true;
                    checkCambio = true;
                    airplane.setCapacidad(capacidadNew);
                    this.updateAirplaneAction.update(airplane);

                }

            }

            if (checkCapacidad == true) {
                if (checkCambio == true) {

                    infoAirplane = this.extractSearchAirplaneAction.extract(airplane.getPlaca());
                    

                    System.out.println("\n\n    Información actualizada del Avión");
                    System.out.println("- - - - - - - - - - - - - - - - - - - - - ");
                    System.out.println("                  ||");
                    System.out.println("                  ||");
                    System.out.println("                  ||");
                    System.out.println("                  \\/");

                    viewSearchAirplaneAction.view(infoAirplane);
                    MainActualizarAvion.main(empleado);

                }
            }



        }



    }
    

}
