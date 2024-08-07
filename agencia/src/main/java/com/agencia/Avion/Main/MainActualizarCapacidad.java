package com.agencia.Avion.Main;

import com.agencia.Avion.Adapter.In.ExtractAirplaneRepository;
import com.agencia.Avion.Adapter.In.FormAirplaneUpdateCapacity;
import com.agencia.Avion.Adapter.In.GeneratedInfoSearchAirplane;
import com.agencia.Avion.Adapter.In.MYSQLAirplaneSearchRepository;
import com.agencia.Avion.Adapter.In.PlatesExtractionRepository;
import com.agencia.Avion.Adapter.Out.MySQLAirplaneUpdateCapacityRepository;
import com.agencia.Avion.Application.ExistentPlatesExtraction;
import com.agencia.Avion.Application.ExtractAirplaneAction;
import com.agencia.Avion.Application.ExtractSearchAirplaneAction;
import com.agencia.Avion.Application.UpdateAirplaneAction;
import com.agencia.Avion.Application.ViewSearchAirplaneAction;
import com.agencia.Avion.Domain.Service.ExtractAirplaneService;
import com.agencia.Avion.Domain.Service.PlatesExtractionService;
import com.agencia.Avion.Domain.Service.SearchAirplaneService;
import com.agencia.Avion.Domain.Service.UpdateAirplaneService;
import com.agencia.Avion.Domain.Service.ViewSearchAirplaneService;
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
