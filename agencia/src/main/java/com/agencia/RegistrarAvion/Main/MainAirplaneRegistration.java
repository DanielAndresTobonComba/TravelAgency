package com.agencia.RegistrarAvion.Main;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Adapater.In.ExtractAirplaneModelsRepository;
import com.agencia.RegistrarAvion.Adapater.In.ExtractAirplaneStatusesRepository;
import com.agencia.RegistrarAvion.Adapater.In.FormAirplaneRegistration;
import com.agencia.RegistrarAvion.Adapater.In.PlatesExtractionRepository;
import com.agencia.RegistrarAvion.Adapater.In.ViewInfoModelRepository;
import com.agencia.RegistrarAvion.Adapater.In.ViewInfoStatusRepository;
import com.agencia.RegistrarAvion.Adapater.Out.MySQLAirplaneRegistrationRepository;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Application.ExtractRegistersAction;
import com.agencia.RegistrarAvion.Application.RecordAirplaneAction;
import com.agencia.RegistrarAvion.Application.ViewInfoModelsAction;
import com.agencia.RegistrarAvion.Application.ViewInfoStatusAction;
import com.agencia.RegistrarAvion.Domain.Services.AirplaneRecordService;
import com.agencia.RegistrarAvion.Domain.Services.ExtractRegistersService;
import com.agencia.RegistrarAvion.Domain.Services.PlatesExtractionService;
import com.agencia.RegistrarAvion.Domain.Services.ViewInfoService;

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
