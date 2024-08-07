package com.agencia.Avion.Main;

import com.agencia.Avion.Adapter.In.ExtractAirplaneModelsRepository;
import com.agencia.Avion.Adapter.In.ExtractAirplaneStatusesRepository;
import com.agencia.Avion.Adapter.In.FormAirplaneRegistration;
import com.agencia.Avion.Adapter.In.PlatesExtractionRepository;
import com.agencia.Avion.Adapter.In.ViewInfoModelRepository;
import com.agencia.Avion.Adapter.In.ViewInfoStatusRepository;
import com.agencia.Avion.Adapter.Out.MySQLAirplaneRegistrationRepository;
import com.agencia.Avion.Application.ExistentPlatesExtraction;
import com.agencia.Avion.Application.ExtractRegistersAction;
import com.agencia.Avion.Application.RecordAirplaneAction;
import com.agencia.Avion.Application.ViewInfoModelsAction;
import com.agencia.Avion.Application.ViewInfoStatusAction;
import com.agencia.Avion.Domain.Service.AirplaneRecordService;
import com.agencia.Avion.Domain.Service.ExtractRegistersService;
import com.agencia.Avion.Domain.Service.PlatesExtractionService;
import com.agencia.Avion.Domain.Service.ViewInfoService;
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
