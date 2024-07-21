package com.agencia.RegistrarAvion.Adapater.In;

import java.sql.ResultSet;
import java.util.List;

import com.agencia.EmployeeView.MainEmployeeView.MainEmployeeView;
import com.agencia.GestionAvion.Main.MainMenuGestionAvion;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Application.ExtractRegistersAction;
import com.agencia.RegistrarAvion.Application.RecordAirplaneAction;
import com.agencia.RegistrarAvion.Application.ViewInfoModelsAction;
import com.agencia.RegistrarAvion.Application.ViewInfoStatusAction;
import com.agencia.RegistrarAvion.Domain.Entity.Airplane;
import com.agencia.Verifiers.CheckDate;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class FormAirplaneRegistration {

    private ExistentPlatesExtraction existentPlatesExtraction;
    private ViewInfoModelsAction viewInfoModelAction;
    private ExtractRegistersAction extractRegistersModelsAction;
    private ViewInfoStatusAction viewInfoStatusAction;
    private ExtractRegistersAction extractRegistersStatusAction;
    private RecordAirplaneAction recordAirplaneAction;
    

    

    public FormAirplaneRegistration(ExistentPlatesExtraction existentPlatesExtraction,
            ViewInfoModelsAction viewInfoModelAction, ExtractRegistersAction extractRegistersModelsAction,
            ViewInfoStatusAction viewInfoStatusAction, ExtractRegistersAction extractRegistersStatusAction,
            RecordAirplaneAction recordAirplaneAction) {
                
        this.existentPlatesExtraction = existentPlatesExtraction;
        this.viewInfoModelAction = viewInfoModelAction;
        this.extractRegistersModelsAction = extractRegistersModelsAction;
        this.viewInfoStatusAction = viewInfoStatusAction;
        this.extractRegistersStatusAction = extractRegistersStatusAction;
        this.recordAirplaneAction =  recordAirplaneAction;
        
    }




    public void SeeResults(Empleado empleado) {
        List<String> listRegisteredPlates = this.existentPlatesExtraction.executeExtract(); 
        ResultSet infoModels = this.extractRegistersModelsAction.extractInfo();
        ResultSet infoStatus = this.extractRegistersStatusAction.extractInfo();
        boolean checkPlaca = false;
        boolean exitPlaca = false;
        String placa = "";
        boolean checkCapacidad = false;
        boolean exitCapacidad = false;
        int capacidad = 0;
        boolean checkFechaFabricacion = false;
        boolean exitFechaFabricacion = false;
        String fechaFabricacion = "";
        boolean checkModelo = false;
        boolean exitModelo = false;
        int codModelo = 0;
        boolean checkEstado = false;
        boolean exitEstado = false;
        int codEstado = 0;
        

        System.out.println("\n______________________\n");
        System.out.println("   REGISTRO DE AVIÓN");
        System.out.println("_______________________\n");

        // Registro de la placa

        while (exitPlaca == false) {

            System.out.println("\n\n--> Ingrese la placa del Avión");
            System.out.println("....................................");
            System.out.println("      [EXIT/exit] para Salir");
            System.out.print(">>> ");

            placa = CheckString.check("Ingrese la placa nuevamente");

            if (placa.toLowerCase().trim().equals("exit")) {

                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                System.out.println("x    REGISTRO CANCELADO   x");
                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                exitPlaca = true;
                MainMenuGestionAvion.main(empleado);



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
                
                System.out.println("\n\n--> Ingrese la capacidad del Avión");
                System.out.println("......................................");
                System.out.println("      (Presiona -1 para Salir)");
                System.out.print(">>> ");

                capacidad = CheckInt.check("Ingrese la capacidad nuevamente");

                if (capacidad == -1) {

                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x    REGISTRO CANCELADO   x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    exitCapacidad = true;
                    MainMenuGestionAvion.main(empleado);
    
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
                
                System.out.println("\n\n--> Ingrese la Fecha de Fabricación del Avión");
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
                    MainMenuGestionAvion.main(empleado);
    
                } else {

                    exitFechaFabricacion = true;
                    checkFechaFabricacion = true;

                }

            }

            // Resgitro del Modelo del Avión

            if (checkFechaFabricacion == true) {

                List<Integer> listCodesModels = this.viewInfoModelAction.executeView(infoModels); 

                while ((exitModelo == false)) {

                    
                    System.out.println("\n\n--> Ingrese el código del modelo");
                    System.out.println("......................................");
                    System.out.println("      (Presiona -1 para Salir)");
                    System.out.print(">>> ");
    
                    codModelo = CheckInt.check("Ingrese el código nuevamente");
    
                    if (codModelo == -1) {
    
                        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("x    REGISTRO CANCELADO   x");
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        exitModelo = true;
                        MainMenuGestionAvion.main(empleado);
        
                    } else if (codModelo <0 && codModelo != -1) {
    
                        System.out.println("\n****************************************");
                        System.out.println("||  EL CÓDIGO NO PUEDE SER NEGATIVO   ||");
                        System.out.println("****************************************\n");
    
                    } else if (listCodesModels.contains(codModelo) == false) {
    
                        System.out.println("\n******************************************");
                        System.out.println("||    CÓDIGO DE MODELO NO REGISTRADO    ||");
                        System.out.println("******************************************\n");
    
                    } else {

                        exitModelo = true;
                        checkModelo = true;

                    }
    
                }
            }


            // Resgitro del Modelo del Avión

            if (checkModelo == true) {

                List<Integer> listCodesStatus = this.viewInfoStatusAction.executeView(infoStatus);  

                while ((exitEstado == false)) {

                    
                    System.out.println("\n\n--> Ingrese el código del estado");
                    System.out.println("......................................");
                    System.out.println("      (Presiona -1 para Salir)");
                    System.out.print(">>> ");
    
                    codEstado = CheckInt.check("Ingrese el código nuevamente");
    
                    if (codEstado == -1) {
    
                        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("x    REGISTRO CANCELADO   x");
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        exitEstado = true;
                        MainMenuGestionAvion.main(empleado);
        
                    } else if (codEstado <0 && codEstado != -1) {
    
                        System.out.println("\n****************************************");
                        System.out.println("||  EL CÓDIGO NO PUEDE SER NEGATIVO   ||");
                        System.out.println("****************************************\n");
    
                    } else if (listCodesStatus.contains(codEstado) == false) {
    
                        System.out.println("\n******************************************");
                        System.out.println("||    CÓDIGO DE ESTADO NO REGISTRADO    ||");
                        System.out.println("******************************************\n");
    
                    } else {

                        exitEstado = true;
                        checkEstado = true;

                    }
    
                }
            }

            if (checkEstado == true) {

                Airplane newAirplane = new Airplane(placa, capacidad, fechaFabricacion, codModelo, codEstado);
                int insertedRow = this.recordAirplaneAction.executeRecord(newAirplane);

                if (insertedRow == 1) {

                    System.out.println("\n\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    System.out.println("   Avión resgitrado EXITOSAMENTE");
                    System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    MainMenuGestionAvion.main(empleado);

                } else {

                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x  FALLÓ AL REGISTRAR AVIÓN  x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    MainMenuGestionAvion.main(empleado);


                }
            }
            
            

            
        }





        


    }

}
