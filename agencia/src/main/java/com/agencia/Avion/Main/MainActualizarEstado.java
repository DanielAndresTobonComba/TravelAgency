package com.agencia.Avion.Main;

import com.agencia.Avion.Adapter.In.ExtractAirplaneRepository;
import com.agencia.Avion.Adapter.In.ExtractAirplaneStatusesRepository;
import com.agencia.Avion.Adapter.In.FormAirplaneUpdateStatus;
import com.agencia.Avion.Adapter.In.GeneratedInfoSearchAirplane;
import com.agencia.Avion.Adapter.In.MYSQLAirplaneSearchRepository;
import com.agencia.Avion.Adapter.In.PlatesExtractionRepository;
import com.agencia.Avion.Adapter.In.ViewInfoStatusRepository;
import com.agencia.Avion.Adapter.Out.MySQLAirplaneUpdateCapacityRepository;
import com.agencia.Avion.Adapter.Out.MySQLAirplaneUpdateStatusRepository;
import com.agencia.Avion.Application.ExistentPlatesExtraction;
import com.agencia.Avion.Application.ExtractAirplaneAction;
import com.agencia.Avion.Application.ExtractRegistersAction;
import com.agencia.Avion.Application.ExtractSearchAirplaneAction;
import com.agencia.Avion.Application.UpdateAirplaneAction;
import com.agencia.Avion.Application.ViewInfoStatusAction;
import com.agencia.Avion.Application.ViewSearchAirplaneAction;
import com.agencia.Avion.Domain.Service.ExtractAirplaneService;
import com.agencia.Avion.Domain.Service.ExtractRegistersService;
import com.agencia.Avion.Domain.Service.PlatesExtractionService;
import com.agencia.Avion.Domain.Service.SearchAirplaneService;
import com.agencia.Avion.Domain.Service.UpdateAirplaneService;
import com.agencia.Avion.Domain.Service.ViewInfoService;
import com.agencia.Avion.Domain.Service.ViewSearchAirplaneService;
import com.agencia.LogIn.Domain.Empleado;

public class MainActualizarEstado {

    public static void main(Empleado empleado) {

        PlatesExtractionService platesExtractionService = new PlatesExtractionRepository();
        ExistentPlatesExtraction existentPlatesExtraction = new ExistentPlatesExtraction(platesExtractionService);
        UpdateAirplaneService updateAirplaneService = new MySQLAirplaneUpdateStatusRepository();
        UpdateAirplaneAction updateAirplaneAction = new UpdateAirplaneAction(updateAirplaneService);
        SearchAirplaneService searchAirplaneService = new MYSQLAirplaneSearchRepository();
        ExtractSearchAirplaneAction extractSearchAirplaneAction = new ExtractSearchAirplaneAction(searchAirplaneService);
        ViewSearchAirplaneService viewSearchAirplaneService = new GeneratedInfoSearchAirplane();
        ViewSearchAirplaneAction viewSearchAirplaneAction = new ViewSearchAirplaneAction(viewSearchAirplaneService);
        ExtractAirplaneService extractAirplaneService = new ExtractAirplaneRepository();
        ExtractAirplaneAction extractAirplaneAction = new ExtractAirplaneAction(extractAirplaneService);
        ExtractRegistersService extractRegistersService = new ExtractAirplaneStatusesRepository();
        ExtractRegistersAction extractRegistersAction = new ExtractRegistersAction(extractRegistersService);
        ViewInfoService viewInfoService = new ViewInfoStatusRepository();
        ViewInfoStatusAction viewInfoStatusAction = new ViewInfoStatusAction(viewInfoService);
        FormAirplaneUpdateStatus formAirplaneUpdateStatus = new FormAirplaneUpdateStatus(existentPlatesExtraction, updateAirplaneAction, extractSearchAirplaneAction, viewSearchAirplaneAction, extractAirplaneAction, extractRegistersAction, viewInfoStatusAction);
        formAirplaneUpdateStatus.start(empleado);

        
    }

}
