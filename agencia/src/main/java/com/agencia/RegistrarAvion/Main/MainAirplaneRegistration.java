package com.agencia.RegistrarAvion.Main;

import com.agencia.RegistrarAvion.Adapater.In.FormAirplaneRegistration;
import com.agencia.RegistrarAvion.Adapater.In.PlatesExtractionRepository;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Domain.Services.PlatesExtractionService;

public class MainAirplaneRegistration {

    public static void mainAirplaneRegistration() {

        PlatesExtractionService platesExtractionService = new PlatesExtractionRepository();
        ExistentPlatesExtraction existentPlatesExtraction = new ExistentPlatesExtraction(platesExtractionService);
        FormAirplaneRegistration formAirplaneRegistration = new FormAirplaneRegistration(existentPlatesExtraction);
        formAirplaneRegistration.SeeResults();
        
    }

}
