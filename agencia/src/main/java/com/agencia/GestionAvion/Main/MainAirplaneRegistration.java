package com.agencia.GestionAvion.Main;

import com.agencia.GestionAvion.Adapter.In.ExtractAirplaneModelsRepository;
import com.agencia.GestionAvion.Adapter.In.ExtractAirplaneStatusesRepository;
import com.agencia.GestionAvion.Adapter.In.FormAirplaneRegistration;
import com.agencia.GestionAvion.Adapter.In.PlatesExtractionRepository;
import com.agencia.GestionAvion.Adapter.In.ViewInfoModelRepository;
import com.agencia.GestionAvion.Adapter.In.ViewInfoStatusRepository;
import com.agencia.GestionAvion.Adapter.Out.MySQLAirplaneRegistrationRepository;
import com.agencia.GestionAvion.Application.ExistentPlatesExtraction;
import com.agencia.GestionAvion.Application.ExtractRegistersAction;
import com.agencia.GestionAvion.Application.RecordAirplaneAction;
import com.agencia.GestionAvion.Application.ViewInfoModelsAction;
import com.agencia.GestionAvion.Application.ViewInfoStatusAction;
import com.agencia.GestionAvion.Domain.Service.AirplaneRecordService;
import com.agencia.GestionAvion.Domain.Service.ExtractRegistersService;
import com.agencia.GestionAvion.Domain.Service.PlatesExtractionService;
import com.agencia.GestionAvion.Domain.Service.ViewInfoService;
import com.agencia.LogIn.Domain.Empleado;

public class MainAirplaneRegistration {

    public static void mainAirplaneRegistration(Empleado empleado) {

        PlatesExtractionService platesExtractionService = new PlatesExtractionRepository();
        ExistentPlatesExtraction existentPlatesExtraction = new ExistentPlatesExtraction(platesExtractionService);

        ViewInfoService extractInfoModelService = new ViewInfoModelRepository();
        ViewInfoModelsAction viewModelsInfoAction = new ViewInfoModelsAction(extractInfoModelService);

        ExtractRegistersService extractInfoModel = new ExtractAirplaneModelsRepository();
        ExtractRegistersAction extractInfoModelAction = new ExtractRegistersAction(extractInfoModel);

        ViewInfoService extractInfoStatusService = new ViewInfoStatusRepository();
        ViewInfoStatusAction viewInfoStatusAction = new ViewInfoStatusAction(extractInfoStatusService);

        ExtractRegistersService extractInfoStatus = new ExtractAirplaneStatusesRepository();
        ExtractRegistersAction extractInfoStatusAction = new ExtractRegistersAction(extractInfoStatus);

        AirplaneRecordService airplaneRecordService = new MySQLAirplaneRegistrationRepository();
        RecordAirplaneAction recordAirplaneAction = new RecordAirplaneAction(airplaneRecordService);

        FormAirplaneRegistration formAirplaneRegistration = new FormAirplaneRegistration(existentPlatesExtraction, viewModelsInfoAction, extractInfoModelAction, viewInfoStatusAction, extractInfoStatusAction, recordAirplaneAction);
        
        formAirplaneRegistration.SeeResults(empleado);
        
    }

}
