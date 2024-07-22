package com.agencia.ActualizarAvion.MainActualizarAvion;

import com.agencia.ActualizarAvion.Adapter.In.ExtractAirplaneRepository;
import com.agencia.ActualizarAvion.Adapter.In.FormAirplaneUpdateCapacity;
import com.agencia.ActualizarAvion.Adapter.Out.MySQLAirplaneUpdateCapacityRepository;
import com.agencia.ActualizarAvion.Application.ExtractAirplaneAction;
import com.agencia.ActualizarAvion.Application.UpdateAirplaneAction;
import com.agencia.ActualizarAvion.Domain.Service.ExtractAirplaneService;
import com.agencia.ActualizarAvion.Domain.Service.UpdateAirplaneService;
import com.agencia.ConsultarAvion.Adapter.In.GeneratedInfoSearchAirplane;
import com.agencia.ConsultarAvion.Adapter.In.MYSQLAirplaneSearchRepository;
import com.agencia.ConsultarAvion.Application.ExtractSearchAirplaneAction;
import com.agencia.ConsultarAvion.Application.ViewSearchAirplaneAction;
import com.agencia.ConsultarAvion.Domain.Service.SearchAirplaneService;
import com.agencia.ConsultarAvion.Domain.Service.ViewSearchAirplaneService;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Adapater.In.PlatesExtractionRepository;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Domain.Services.PlatesExtractionService;

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
