package com.agencia.RegistrarAvion.Main;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Adapater.In.ExtractAirplaneModelsRepository;
import com.agencia.RegistrarAvion.Adapater.In.FormAirplaneRegistration;
import com.agencia.RegistrarAvion.Adapater.In.PlatesExtractionRepository;
import com.agencia.RegistrarAvion.Adapater.In.ViewInfoModelRepository;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Application.ExtractRegistersAction;
import com.agencia.RegistrarAvion.Application.ViewInfoModelsAction;
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
        FormAirplaneRegistration formAirplaneRegistration = new FormAirplaneRegistration(existentPlatesExtraction, viewModelsInfoAction, extractInfoModelAction);
        formAirplaneRegistration.SeeResults(empleado);
        
    }

}
