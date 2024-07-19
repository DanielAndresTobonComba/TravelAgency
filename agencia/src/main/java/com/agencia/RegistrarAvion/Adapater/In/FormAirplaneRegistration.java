package com.agencia.RegistrarAvion.Adapater.In;

import java.sql.ResultSet;
import java.util.List;

import com.agencia.EmployeeView.MainEmployeeView.MainEmployeeView;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Application.ExtractRegistersAction;
import com.agencia.RegistrarAvion.Application.ViewInfoModelsAction;
import com.agencia.Verifiers.CheckDate;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class FormAirplaneRegistration {

    private ExistentPlatesExtraction existentPlatesExtraction;
    private ViewInfoModelsAction viewInfoModelAction;
    private ExtractRegistersAction extractRegistersModelsAction;
    

    public FormAirplaneRegistration(ExistentPlatesExtraction existentPlatesExtraction, ViewInfoModelsAction viewInfoModelAction, ExtractRegistersAction extractRegistersModelsAction) {
        this.existentPlatesExtraction = existentPlatesExtraction;
        this.viewInfoModelAction = viewInfoModelAction;
        this.extractRegistersModelsAction = extractRegistersModelsAction;
        //this.extractRegistersStatusACtion = extractRegistersStatusACtion;

    }

    public void SeeResults(Empleado empleado) {
        List<String> listRegisteredPlates = this.existentPlatesExtraction.executeExtract(); 
        ResultSet infoModels = this.extractRegistersModelsAction.extractInfo();
        boolean checkPlaca = false;
        boolean exitPlaca = false;
        String placa = "";
        boolean checkCapacidad = false;
        boolean exitCapacidad = false;
        int capacidad = 0;
        boolean checkFechaFabricacion = false;
        boolean exitFechaFabricacion = false;
        String fechaFabricacion = "";
        

        System.out.println("\n______________________\n");
        System.out.println("   REGISTRO DE AVIÓN");
        System.out.println("_______________________\n");

        // Registro de la placa

        while (exitPlaca == false) {

            System.out.println("\n--> Ingrese la placa del Avión");
            System.out.println("....................................");
            System.out.println("      [EXIT/exit] para Salir");
            System.out.print(">>> ");

            placa = CheckString.check("Ingrese la placa nuevamente");

            if (placa.toLowerCase().trim().equals("exit")) {

                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x    REGISTRO CANCELADO   x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                exitPlaca = true;
                MainEmployeeView.mainEmployeeView(empleado);



            } else {
                
                if (listRegisteredPlates.contains(placa)) {

                    System.out.println("\n********************************************");
                    System.out.println("*              NO ES POSIBLE               *");
                    System.out.println("*------------------------------------------*");
                    System.out.println("*  Esta placa ya se encuentra registrada   *");
                    System.out.println("********************************************\n");

                } else {

                    exitPlaca = true;
                    checkPlaca = true;

                }

                //checkPlaca = true;
            }
            
        }

        // registro de la capcidad del avión

        if (checkPlaca == true) {
            while ((exitCapacidad == false)) {
                
                System.out.println("\n--> Ingrese la capacidad del Avión");
                System.out.println("......................................");
                System.out.println("      (Presiona -1 para Salir)");
                System.out.print(">>> ");

                capacidad = CheckInt.check("Ingrese la capacidad nuevamente");

                if (capacidad == -1) {

                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x    REGISTRO CANCELADO   x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    exitCapacidad = true;
                    MainEmployeeView.mainEmployeeView(empleado);
    
                } else if (capacidad <=0 && capacidad != -1) {

                    System.out.println("\n*******************************************");
                    System.out.println("||  LA CAPACIDAD NO PUEDE SER NEGATIVA   ||");
                    System.out.println("*******************************************\n");

                } else {

                    exitCapacidad = true;
                    checkCapacidad = true;

                }

            }
        }

        // Registro de la Fecha de Fabricación del Avión

        if (checkCapacidad == true) {
            while ((exitFechaFabricacion == false)) {
                
                System.out.println("\n--> Ingrese la Fecha de Fabricación del Avión");
                System.out.println("                  [AAAA-MM-DD]");
                System.out.println(".................................................");
                System.out.println("      [EXIT/exit] para Salir");
                System.out.print(">>> ");

                fechaFabricacion = CheckDate.check("Ingrese nuevamente la fecha de fabricación");

                if (fechaFabricacion.toLowerCase().trim().equals("exit")) {

                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x    REGISTRO CANCELADO   x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    exitFechaFabricacion = true;
                    MainEmployeeView.mainEmployeeView(empleado);
    
                } else {

                    exitFechaFabricacion = true;
                    checkFechaFabricacion = true;

                }

            }

            List<Integer> listCodesModels = this.viewInfoModelAction.executeView(infoModels); 

            
        }





        


    }

}
