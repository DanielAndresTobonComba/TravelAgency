package com.agencia.CheckIn.MainCheckIn;


import com.agencia.CheckIn.Adpater.In.ExtractAirplaneCapacityRepository;
import com.agencia.CheckIn.Adpater.In.ExtractConnFlightEntity;
import com.agencia.CheckIn.Adpater.In.ExtractConnectionNumbersList;
import com.agencia.CheckIn.Adpater.In.ExtractDocumentTypesList;
import com.agencia.CheckIn.Adpater.In.ExtractReservationsEntity;
import com.agencia.CheckIn.Adpater.In.ExtractReservationsRepository;
import com.agencia.CheckIn.Adpater.In.ExtractReservedChairsList;
import com.agencia.CheckIn.Adpater.In.FormCheckIn;
import com.agencia.CheckIn.Adpater.Out.MySQLInsertChair;
import com.agencia.CheckIn.Adpater.Out.VerifyCheckRepository;
import com.agencia.CheckIn.Application.ExtractAirplaneCapacityAction;
import com.agencia.CheckIn.Application.ExtractConnectionNumbersAction;
import com.agencia.CheckIn.Application.ExtractDocumentAction;
import com.agencia.CheckIn.Application.ExtractInfoConnFlightAction;
import com.agencia.CheckIn.Application.ExtractInfoReservationsAction;
import com.agencia.CheckIn.Application.ExtractReservationsAction;
import com.agencia.CheckIn.Application.ExtractReservedChairsAction;
import com.agencia.CheckIn.Application.TakeChairAction;
import com.agencia.CheckIn.Application.VerifyCheckInAction;
import com.agencia.CheckIn.Domain.Service.ExtractAirplaneCapacityService;
import com.agencia.CheckIn.Domain.Service.ExtractConnectionNumbersService;
import com.agencia.CheckIn.Domain.Service.ExtractDocumentsService;
import com.agencia.CheckIn.Domain.Service.ExtractInfoConnFlightService;
import com.agencia.CheckIn.Domain.Service.ExtractInfoReservationsService;
import com.agencia.CheckIn.Domain.Service.ExtractReservationsService;
import com.agencia.CheckIn.Domain.Service.ExtractReservedChairsService;
import com.agencia.CheckIn.Domain.Service.TakeChairService;
import com.agencia.CheckIn.Domain.Service.VerifyCheckInService;

public class MainCheckIn {

    public static void main() {
        // Initialize Services
        ExtractReservationsService extractReservationsService = new ExtractReservationsRepository();
        ExtractInfoReservationsService extractInfoReservationsService = new ExtractReservationsEntity();
        ExtractInfoConnFlightService extractInfoConnFlightService = new ExtractConnFlightEntity();
        ExtractDocumentsService extractDocumentsService = new ExtractDocumentTypesList();
        ExtractConnectionNumbersService extractConnectionNumbersService = new ExtractConnectionNumbersList();
        ExtractReservedChairsService extractReservedChairsService = new ExtractReservedChairsList();
        ExtractAirplaneCapacityService extractAirplaneCapacityService = new ExtractAirplaneCapacityRepository();
        TakeChairService takeChairService = new MySQLInsertChair();
        VerifyCheckInService verifyCheckInService = new VerifyCheckRepository();

        // Initialize Actions
        ExtractReservationsAction extractReservationsAction = new ExtractReservationsAction(extractReservationsService);
        ExtractInfoReservationsAction extractInfoReservationsAction = new ExtractInfoReservationsAction(extractInfoReservationsService);
        ExtractInfoConnFlightAction extractInfoConnFlightAction = new ExtractInfoConnFlightAction(extractInfoConnFlightService);
        ExtractDocumentAction extractDocumentAction = new ExtractDocumentAction(extractDocumentsService);
        ExtractConnectionNumbersAction extractConnectionNumbersAction = new ExtractConnectionNumbersAction(extractConnectionNumbersService);
        ExtractReservedChairsAction     extractReservedChairsAction = new ExtractReservedChairsAction(extractReservedChairsService); 
        ExtractAirplaneCapacityAction extractAirplaneCapacityAction = new ExtractAirplaneCapacityAction(extractAirplaneCapacityService);
        TakeChairAction takeChairAction = new TakeChairAction(takeChairService);
        VerifyCheckInAction verifyCheckInAction = new VerifyCheckInAction(verifyCheckInService);

        // Initialize and start FormCheckIn
        FormCheckIn formCheckIn = new FormCheckIn(
            extractReservationsAction, 
            extractInfoReservationsAction, 
            extractInfoConnFlightAction, 
            extractDocumentAction, 
            extractConnectionNumbersAction,
            extractReservedChairsAction,
            extractAirplaneCapacityAction,
            takeChairAction,
            verifyCheckInAction
        );

        formCheckIn.start();
        

    }

}
