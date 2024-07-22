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
import com.agencia.RegistrarAvion.Application.ExtractRegistersAction;
import com.agencia.RegistrarAvion.Application.ViewInfoStatusAction;
import com.agencia.RegistrarAvion.Domain.Entity.Airplane;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class FormAirplaneUpdateStatus {

   private ExistentPlatesExtraction existentPlatesExtraction;
    private UpdateAirplaneAction updateAirplaneAction;
    private ExtractSearchAirplaneAction extractSearchAirplaneAction;
    private ViewSearchAirplaneAction viewSearchAirplaneAction;
    private ExtractAirplaneAction extractAirplaneAction;
    ExtractRegistersAction extractRegistersStatusAction;
    ViewInfoStatusAction viewInfoStatusAction;

    

    

    public FormAirplaneUpdateStatus(ExistentPlatesExtraction existentPlatesExtraction,
            UpdateAirplaneAction updateAirplaneAction, ExtractSearchAirplaneAction extractSearchAirplaneAction,
            ViewSearchAirplaneAction viewSearchAirplaneAction, ExtractAirplaneAction extractAirplaneAction,
            ExtractRegistersAction extractRegistersAction, ViewInfoStatusAction viewInfoStatusAction) {
        
        this.existentPlatesExtraction = existentPlatesExtraction;
        this.updateAirplaneAction = updateAirplaneAction;
        this.extractSearchAirplaneAction = extractSearchAirplaneAction;
        this.viewSearchAirplaneAction = viewSearchAirplaneAction;
        this.extractAirplaneAction = extractAirplaneAction;
        this.extractRegistersStatusAction = extractRegistersAction;
        this.viewInfoStatusAction = viewInfoStatusAction;
    }


    public void start(Empleado empleado) {

        List<String> listRegisteredPlates = this.existentPlatesExtraction.executeExtract(); 
        ResultSet infoStatus = null;
        ResultSet infoAirplane = null;
        boolean checkPlaca = false;
        boolean exitPlaca = false;
        String placa = "";
        Airplane airplane = null;
        int estadoIdBefore = 0;
        int estadoIdNew = 0;
        boolean exitEstado = false;
        boolean checkEstado = false;
        boolean checkCambio = false;

        System.out.println("\n______________________________________\n");
        System.out.println("     ACTUALIZAR ESTADO DE AVIÓN");
        System.out.println("______________________________________\n");

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
            estadoIdBefore = airplane.getEstado_id();

            System.out.println("\n\n    Información del Avión");
            System.out.println("   que se desea actualizar");
            System.out.println("- - - - - - - - - - - - - - - -");
            System.out.println("              ||");
            System.out.println("              ||");
            System.out.println("              ||");
            System.out.println("              \\/");

            viewSearchAirplaneAction.view(infoAirplane);

            infoStatus = this.extractRegistersStatusAction.extractInfo();
            List<Integer> listCodesStatus = this.viewInfoStatusAction.executeView(infoStatus); 

             while ((exitEstado == false)) {
                
                System.out.println("\n\n--> Ingrese el estado del Avión");
                System.out.println("......................................");
                System.out.println("      (Presiona -1 para Salir)");
                System.out.print(">>> ");

                estadoIdNew = CheckInt.check("Ingrese el código del estado nuevamente");

                if (estadoIdNew == -1) {

                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x    ACTUALIZACIÓN CANCELADA   x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    exitEstado = true;
                    MainActualizarAvion.main(empleado);
    
                } else if (estadoIdNew <=0 && estadoIdNew != -1) {

                    System.out.println("\n*******************************************");
                    System.out.println("||  EL CÓDIGO NO PUEDE SER NEGATIVO   ||");
                    System.out.println("*******************************************\n");

                } else if (estadoIdBefore == estadoIdNew) {

                    System.out.println("\n**********************************************");
                    System.out.println("||          ¡ACTUALIZACIÓN CANCELADA!          ||");
                    System.out.println("||       Este código es igual al anterior      ||");
                    System.out.println("*************************************************\n");
                    
                } else if (listCodesStatus.contains(estadoIdNew) == false) {
    
                    System.out.println("\n******************************************");
                    System.out.println("||    CÓDIGO DE ESTADO NO REGISTRADO    ||");
                    System.out.println("******************************************\n");

                } else {

                    exitEstado = true;
                    checkEstado = true;
                    checkCambio = true;
                    airplane.setEstado_id(estadoIdNew);
                    this.updateAirplaneAction.update(airplane);

                }

            }

            if (checkEstado == true) {
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
