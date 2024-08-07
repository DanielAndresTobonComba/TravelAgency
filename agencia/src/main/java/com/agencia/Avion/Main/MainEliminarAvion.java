package com.agencia.Avion.Main;

import com.agencia.Avion.Adapter.In.FormAirplaneDeletion;
import com.agencia.Avion.Adapter.In.PlatesExtractionRepository;
import com.agencia.Avion.Adapter.Out.MYSQLAirplaneDeletionRepository;
import com.agencia.Avion.Application.DeleteAirplaneAction;
import com.agencia.Avion.Application.ExistentPlatesExtraction;
import com.agencia.Avion.Domain.Service.AirplaneDeleteService;
import com.agencia.Avion.Domain.Service.PlatesExtractionService;
import com.agencia.LogIn.Domain.Empleado;

public class MainEliminarAvion {

    public static void main(Empleado empleado) {

        PlatesExtractionService platesExtractionService = new PlatesExtractionRepository();
        ExistentPlatesExtraction existentPlatesExtraction = new ExistentPlatesExtraction(platesExtractionService);
        AirplaneDeleteService airplaneDeleteService = new MYSQLAirplaneDeletionRepository();
        DeleteAirplaneAction deleteAirplaneAction = new DeleteAirplaneAction(airplaneDeleteService);
        FormAirplaneDeletion formAirplaneDeletion = new FormAirplaneDeletion(existentPlatesExtraction, deleteAirplaneAction);
        formAirplaneDeletion.delete(empleado);

        
    }

}
