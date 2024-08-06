package com.agencia.GestionAvion.Main;

import com.agencia.GestionAvion.Adapter.In.FormAirplaneDeletion;
import com.agencia.GestionAvion.Adapter.In.PlatesExtractionRepository;
import com.agencia.GestionAvion.Adapter.Out.MYSQLAirplaneDeletionRepository;
import com.agencia.GestionAvion.Application.DeleteAirplaneAction;
import com.agencia.GestionAvion.Application.ExistentPlatesExtraction;
import com.agencia.GestionAvion.Domain.Service.AirplaneDeleteService;
import com.agencia.GestionAvion.Domain.Service.PlatesExtractionService;
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
