package com.agencia.CheckIn.Adpater.In;

import java.util.List;

import com.agencia.CheckIn.Application.ExtractAirplaneCapacityAction;
import com.agencia.CheckIn.Application.ExtractConnectionNumbersAction;
import com.agencia.CheckIn.Application.ExtractDocumentAction;
import com.agencia.CheckIn.Application.ExtractInfoConnFlightAction;
import com.agencia.CheckIn.Application.ExtractInfoReservationsAction;
import com.agencia.CheckIn.Application.ExtractReservationsAction;
import com.agencia.CheckIn.Application.ExtractReservedChairsAction;
import com.agencia.CheckIn.Application.TakeChairAction;
import com.agencia.CheckIn.Application.VerifyCheckInAction;
import com.agencia.CheckIn.Domain.Entity.ConnectionFlight;
import com.agencia.CheckIn.Domain.Entity.Reservation;
import com.agencia.CheckIn.MainCheckIn.MainCheckIn;
import com.agencia.Main.Main;
import com.agencia.Verifiers.AvailableChairsList;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;


public class FormCheckIn {

    private ExtractReservationsAction extractReservationsAction;
    private ExtractInfoReservationsAction extractInfoReservationsAction;
    private ExtractInfoConnFlightAction extractInfoConnFlightAction;
    private ExtractDocumentAction extractDocumentAction;
    private ExtractConnectionNumbersAction extractConnectionNumbersAction;
    private ExtractReservedChairsAction extractReservedChairsAction;
    private ExtractAirplaneCapacityAction extractAirplaneCapacityAction;
    private TakeChairAction takeChairAction;
    private VerifyCheckInAction verifyCheckInAction;



    public FormCheckIn(ExtractReservationsAction extractReservationsAction,
            ExtractInfoReservationsAction extractInfoReservationsAction,
            ExtractInfoConnFlightAction extractInfoConnFlightAction, ExtractDocumentAction extractDocumentAction,
            ExtractConnectionNumbersAction extractConnectionNumbersAction,
            ExtractReservedChairsAction extractReservedChairsAction,
            ExtractAirplaneCapacityAction extractAirplaneCapacityAction, TakeChairAction takeChairAction,
            VerifyCheckInAction verifyCheckInAction) {
        this.extractReservationsAction = extractReservationsAction;
        this.extractInfoReservationsAction = extractInfoReservationsAction;
        this.extractInfoConnFlightAction = extractInfoConnFlightAction;
        this.extractDocumentAction = extractDocumentAction;
        this.extractConnectionNumbersAction = extractConnectionNumbersAction;
        this.extractReservedChairsAction = extractReservedChairsAction;
        this.extractAirplaneCapacityAction = extractAirplaneCapacityAction;
        this.takeChairAction = takeChairAction;
        this.verifyCheckInAction = verifyCheckInAction;
    }



    public void start() {

        List<Integer> listReservationsId = this.extractReservationsAction.extract();
        List<Integer> listDocumentTypes = null;
        Reservation reservation = null;
        boolean checkReservacion = false;
        boolean exitReservacion = false;
        int reservacionId = 0;
        boolean checkTipoDocumento = false;
        boolean exitTipoDocumento = false;
        int tipoDocumentoInput = 0;
        boolean checkDocumento = false;
        boolean exitDocumento = false;
        String dniInput = "";
        boolean checkConexion = false;
        boolean exitConexion = false;
        String numeroConexionInput = "";
        List<String> listConnectionNumbers = null;
        ConnectionFlight connectionFlight = null;
        List<String> listReservedChairs = null;
        int capacity = 0;
        boolean checkChair = false;
        boolean exitChair = false;
        String chair = "";
        int insertedRows = 0;
        int verifyiedRows = 0;
        boolean checkIn = false;



        System.out.println("\n______________________\n");
        System.out.println("    C H E C K - I N");
        System.out.println("_______________________\n");

        // Verificación de Rservación
        while ((exitReservacion == false)) {
                
                System.out.println("\n\n--> Ingrese el código de su Reserva");
                System.out.println(".........................................");
                System.out.println("        (Presiona -1 para Salir)");
                System.out.print(">>> ");

                reservacionId = CheckInt.check("Ingreseel código nuevamente");

                if (reservacionId == -1) {

                    System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    System.out.println("x    CHECK-IN CANCELADO   x");
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                    exitReservacion = true;
                    Main.main(null);
    
                } else if (reservacionId <=0 && reservacionId != -1) {

                    System.out.println("\n*******************************************");
                    System.out.println("||    EL CÓDIGO NO PUEDE SER NEGATIVO    ||");
                    System.out.println("*******************************************\n");

                } else if (listReservationsId.contains(reservacionId) == false) {
    
                    System.out.println("\n***********************************************");
                    System.out.println("||    CÓDIGO DE RESERVACIÓN NO REGISTRADO    ||");
                    System.out.println("***********************************************\n"); 
                
                } else {

                    exitReservacion = true;
                    checkReservacion = true;
                    reservation = this.extractInfoReservationsAction.extract(reservacionId);
                    listConnectionNumbers = this.extractConnectionNumbersAction.extract(reservation.getViaje_id());

                }

            }

            // Ingreso tipo de documento

            if (checkReservacion == true) {

                listDocumentTypes = this.extractDocumentAction.extract();

                while ((exitTipoDocumento == false)) {
                
                    System.out.println("\n\n--> Ingrese el código de tipo de Documento");
                    System.out.println("...............................................");
                    System.out.println("        (Presiona -1 para Salir)");
                    System.out.print(">>> ");
    
                    tipoDocumentoInput = CheckInt.check("Ingreseel código nuevamente");
    
                    if (tipoDocumentoInput == -1) {
    
                        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("x    CHECK-IN CANCELADO   x");
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        exitTipoDocumento = true;
                        Main.main(null);
        
                    } else if (tipoDocumentoInput <=0 && tipoDocumentoInput != -1) {
    
                        System.out.println("\n*******************************************");
                        System.out.println("||    EL CÓDIGO NO PUEDE SER NEGATIVO    ||");
                        System.out.println("*******************************************\n");
    
                    } else if (listDocumentTypes.contains(tipoDocumentoInput) == false) {
        
                        System.out.println("\n*****************************************************");
                        System.out.println("||    CÓDIGO DE TIPO DE DOCUMENTO NO REGISTRADO    ||");
                        System.out.println("*****************************************************\n"); 
                    
                    } else {
    
                        exitTipoDocumento = true;
                        checkTipoDocumento = true;
    
                    }

                }

            }

            // Ingreso del Documento 

            if (checkTipoDocumento == true) {
            
                while (exitDocumento == false) {
                    
                

                    System.out.println("\n\n--> Ingrese su documento");
                    System.out.println(".................................");
                    System.out.println("    [EXIT/exit] para Salir");
                    System.out.print(">>> ");

                    dniInput = CheckString.check("Ingrese el documento nuevamente");

                    if (dniInput.toLowerCase().trim().equals("exit")) {

                        System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        System.out.println("x    CHECK-IN CANCELADO   x");
                        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                        exitDocumento = true;
                        Main.main(null);
        
                    } else if (dniInput.trim().toLowerCase().equals(reservation.getDni().trim().toLowerCase()) == false  || tipoDocumentoInput != reservation.getTipoDocumento_id()){

                        System.out.println("\n**********************************************");
                        System.out.println("*         NO ES POSIBLE HACER CHECK-IN         *");
                        System.out.println("*----------------------------------------------*");
                        System.out.println("*   No coincide la información del documento   *");
                        System.out.println("************************************************\n");

                    } else {

                        exitDocumento = true;
                        checkDocumento = true;

                    }

                }

                // Ingresar el vuelo para hacer CheckIn

                if (checkDocumento == true) {

                        while(exitConexion== false) {

                            System.out.println("\n\n--> Ingrese el numero de Vuelo para hacer Check-In");
                            System.out.println(".................................................................");
                            System.out.println("                  [EXIT/exit] para Salir");
                            System.out.print(">>> ");

                            numeroConexionInput = CheckString.check("Ingrese el numero de vuelo nuevamente");

                            if (numeroConexionInput.toLowerCase().trim().equals("exit")) {

                                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                System.out.println("x    CHECK-IN CANCELADO   x");
                                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                exitConexion = true;
                                Main.main(null);
                
                            } else if (!listConnectionNumbers.contains(numeroConexionInput.trim())) {

                                System.out.println("\n***************************************************");
                                System.out.println("*           NO ES POSIBLE HACER CHECK-IN          *");
                                System.out.println("*-------------------------------------------------*");
                                System.out.println("*   Este vuelo no se encuentra dentro del viaje   *");
                                System.out.println("***************************************************\n");

                            } else {

                                checkConexion = true;
                                exitConexion = true;
                                connectionFlight = this.extractInfoConnFlightAction.extract(numeroConexionInput);
                                verifyiedRows = this.verifyCheckInAction.verify(connectionFlight.getId(), reservacionId);

                            }

                        }


                }


                // Aquì vamos  a validar si la perdsona ya hizo CheckIn
                if (checkConexion == true) {

                    if (verifyiedRows == 0) {

                        checkIn = true;

                    } else {

                        System.out.println("\n***************************************");
                        System.out.println("*         YA HICISTE CHECK-IN         *");
                        System.out.println("***************************************\n");
                        Main.main(null);
                    }
                }


                // Elegir Asiento

                if (checkIn == true) {

                    listReservedChairs = this.extractReservedChairsAction.extract(numeroConexionInput);
                    System.out.println(listReservedChairs);
                    capacity = this.extractAirplaneCapacityAction.extract(connectionFlight.getAvion_id());

                    System.out.println("\n================================");
                    System.out.println(String.format("|| Capacidad: %s pasajeros    ||", capacity));
                    System.out.println("================================");

                    System.out.println("\n");

                    
                    List<String> listAvailableChairs = AvailableChairsList.generate(capacity, listReservedChairs);

                    //if (listReservedChairs.size() == 1) {

                        //chair = listReservedChairs.get(0);
                        //System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        //System.out.println(String.format("  Su puesto asignado es %s", chair));
                        //System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                        //MainCheckIn.main();

                    //} else {

                        while (exitChair == false) {

                            System.out.println("\n\n--> Ingrese el asiento que desea");
                            System.out.println("........................................");
                            System.out.println("       [EXIT/exit] para Salir");
                            System.out.print(">>> ");

                           chair = CheckString.check("Ingrese el asiento nuevamente");

                            if (chair.toLowerCase().trim().equals("exit")) {

                                System.out.println("\nxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                System.out.println("x    CHECK-IN CANCELADO   x");
                                System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxx");
                                exitConexion = true;
                                Main.main(null);
                                
                
                            } else if (!listReservedChairs.contains(chair.trim()) && !listAvailableChairs.contains(chair.trim())) {

                                System.out.println("\n***************************************************");
                                System.out.println("*           NO ES POSIBLE HACER CHECK-IN          *");
                                System.out.println("*-------------------------------------------------*");
                                System.out.println("*              Este asiento no existe             *");
                                System.out.println("***************************************************\n");

                            } else if (listReservedChairs.contains(chair.trim())) {

                                System.out.println("\n***************************************************");
                                System.out.println("*           NO ES POSIBLE HACER CHECK-IN          *");
                                System.out.println("*-------------------------------------------------*");
                                System.out.println("*            Este asiento está ocupado            *");
                                System.out.println("***************************************************\n");

                            } else {

                                checkChair = true;
                                exitChair = true;
                                insertedRows = this.takeChairAction.insert(chair, connectionFlight.getId(), reservacionId);

                            }
                        }

                    //}

                    // Mostrarle a usuario que ha tomado el asiento
                    if (insertedRows == 1) {

                        System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println(String.format("  Su puesto asignado es %s", chair));
                        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                        MainCheckIn.main();


                } else {

                    System.out.println("\n***************************************************");
                    System.out.println("*           NO FUE POSIBLE HACER CHECK-IN          *");
                    System.out.println("****************************************************");
                }



            }
        
        }
            
            

    }
    


}
