package com.agencia.GestionAvion.Main;

import com.agencia.GestionAvion.Adapter.In.ExtractAirplaneRepository;
import com.agencia.GestionAvion.Adapter.In.FormAirplaneUpdateCapacity;
import com.agencia.GestionAvion.Adapter.In.GeneratedInfoSearchAirplane;
import com.agencia.GestionAvion.Adapter.In.MYSQLAirplaneSearchRepository;
import com.agencia.GestionAvion.Adapter.In.PlatesExtractionRepository;
import com.agencia.GestionAvion.Adapter.Out.MySQLAirplaneUpdateCapacityRepository;
import com.agencia.GestionAvion.Application.ExistentPlatesExtraction;
import com.agencia.GestionAvion.Application.ExtractAirplaneAction;
import com.agencia.GestionAvion.Application.ExtractSearchAirplaneAction;
import com.agencia.GestionAvion.Application.UpdateAirplaneAction;
import com.agencia.GestionAvion.Application.ViewSearchAirplaneAction;
import com.agencia.GestionAvion.Domain.Service.ExtractAirplaneService;
import com.agencia.GestionAvion.Domain.Service.PlatesExtractionService;
import com.agencia.GestionAvion.Domain.Service.SearchAirplaneService;
import com.agencia.GestionAvion.Domain.Service.UpdateAirplaneService;
import com.agencia.GestionAvion.Domain.Service.ViewSearchAirplaneService;
import com.agencia.LogIn.Domain.Empleado;

public class MainActualizarCapacidad {

    public static void main(Empleado empleado) {


        PlatesExtractionService platesExtractionService = new PlatesExtractionRepository();
        ExistentPlatesExtraction existentPlatesExtraction = new ExistentPlatesExtraction(platesExtractionService);
        UpdateAirplaneService updateAirplaneService = new MySQLAirplaneUpdateCapacityRepository();
        UpdateAirplaneAction updateAirplaneAction = new UpdateAirplaneAction(updateAirplaneService);
        SearchAirplaneService searchAirplaneService = new MYSQLAirplaneSearchRepository();
        ExtractSearchAirplaneAction extractSearchAirplaneAction = new ExtractSearchAirplaneAction(searchAirplaneService);
        ViewSearchAirplaneService viewSearchAirplaneService = new GeneratedInfoSearchAirplane();
        ViewSearchAirplaneAction viewSearchAirplaneAction = new ViewSearchAirplaneAction(viewSearchAirplaneService);
        ExtractAirplaneService extractAirplaneService = new ExtractAirplaneRepository();
        ExtractAirplaneAction extractAirplaneAction = new ExtractAirplaneAction(extractAirplaneService);
        FormAirplaneUpdateCapacity formAirplaneUpdateCapacity = new FormAirplaneUpdateCapacity(existentPlatesExtraction, updateAirplaneAction, extractSearchAirplaneAction, viewSearchAirplaneAction, extractAirplaneAction);
        formAirplaneUpdateCapacity.updateCapacity(empleado);


        
    }

}
