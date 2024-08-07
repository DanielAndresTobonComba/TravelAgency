package com.agencia.Avion.Main;

import com.agencia.Avion.Adapter.In.FormAirplaneSearch;
import com.agencia.Avion.Adapter.In.GeneratedInfoSearchAirplane;
import com.agencia.Avion.Adapter.In.MYSQLAirplaneSearchRepository;
import com.agencia.Avion.Adapter.In.PlatesExtractionRepository;
import com.agencia.Avion.Application.ExistentPlatesExtraction;
import com.agencia.Avion.Application.ExtractSearchAirplaneAction;
import com.agencia.Avion.Application.ViewSearchAirplaneAction;
import com.agencia.Avion.Domain.Service.PlatesExtractionService;
import com.agencia.Avion.Domain.Service.SearchAirplaneService;
import com.agencia.Avion.Domain.Service.ViewSearchAirplaneService;
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
