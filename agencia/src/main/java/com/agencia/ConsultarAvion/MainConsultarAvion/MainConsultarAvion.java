package com.agencia.ConsultarAvion.MainConsultarAvion;

import com.agencia.ConsultarAvion.Adapter.In.FormAirplaneSearch;
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
