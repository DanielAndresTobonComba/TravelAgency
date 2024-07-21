package com.agencia.EliminarAvion.Main;

import com.agencia.EliminarAvion.Adapter.In.FormAirplaneDeletion;
import com.agencia.EliminarAvion.Adapter.Out.MYSQLAirplaneDeletionRepository;
import com.agencia.EliminarAvion.Application.DeleteAirplaneAction;
import com.agencia.EliminarAvion.Domain.Service.AirplaneDeleteService;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Adapater.In.PlatesExtractionRepository;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Domain.Services.PlatesExtractionService;

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
