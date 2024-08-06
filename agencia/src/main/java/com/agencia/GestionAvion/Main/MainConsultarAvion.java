package com.agencia.GestionAvion.Main;

import com.agencia.GestionAvion.Adapter.In.FormAirplaneSearch;
import com.agencia.GestionAvion.Adapter.In.GeneratedInfoSearchAirplane;
import com.agencia.GestionAvion.Adapter.In.MYSQLAirplaneSearchRepository;
import com.agencia.GestionAvion.Adapter.In.PlatesExtractionRepository;
import com.agencia.GestionAvion.Application.ExistentPlatesExtraction;
import com.agencia.GestionAvion.Application.ExtractSearchAirplaneAction;
import com.agencia.GestionAvion.Application.ViewSearchAirplaneAction;
import com.agencia.GestionAvion.Domain.Service.PlatesExtractionService;
import com.agencia.GestionAvion.Domain.Service.SearchAirplaneService;
import com.agencia.GestionAvion.Domain.Service.ViewSearchAirplaneService;
import com.agencia.LogIn.Domain.Empleado;

public class MainConsultarAvion {

    public static void main(Empleado empleado) {

        PlatesExtractionService platesExtractionService = new PlatesExtractionRepository();
        ExistentPlatesExtraction existentPlatesExtraction = new ExistentPlatesExtraction(platesExtractionService);
        SearchAirplaneService searchAirplaneService = new MYSQLAirplaneSearchRepository();
        ExtractSearchAirplaneAction extractSearchAirplaneAction = new ExtractSearchAirplaneAction(searchAirplaneService);
        ViewSearchAirplaneService  viewSearchAirplaneService = new GeneratedInfoSearchAirplane();
        ViewSearchAirplaneAction viewSearchAirplaneAction = new ViewSearchAirplaneAction(viewSearchAirplaneService);
        FormAirplaneSearch formAirplaneSearch = new FormAirplaneSearch(existentPlatesExtraction, extractSearchAirplaneAction, viewSearchAirplaneAction);

        formAirplaneSearch.search(empleado);


    }

}
