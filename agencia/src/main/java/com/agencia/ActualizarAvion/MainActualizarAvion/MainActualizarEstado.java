package com.agencia.ActualizarAvion.MainActualizarAvion;

import com.agencia.ActualizarAvion.Adapter.In.ExtractAirplaneRepository;
import com.agencia.ActualizarAvion.Adapter.In.FormAirplaneUpdateStatus;
import com.agencia.ActualizarAvion.Adapter.Out.MySQLAirplaneUpdateCapacityRepository;
import com.agencia.ActualizarAvion.Adapter.Out.MySQLAirplaneUpdateStatusRepository;
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
import com.agencia.RegistrarAvion.Adapater.In.ExtractAirplaneStatusesRepository;
import com.agencia.RegistrarAvion.Adapater.In.PlatesExtractionRepository;
import com.agencia.RegistrarAvion.Adapater.In.ViewInfoStatusRepository;
import com.agencia.RegistrarAvion.Application.ExistentPlatesExtraction;
import com.agencia.RegistrarAvion.Application.ExtractRegistersAction;
import com.agencia.RegistrarAvion.Application.ViewInfoStatusAction;
import com.agencia.RegistrarAvion.Domain.Services.ExtractRegistersService;
import com.agencia.RegistrarAvion.Domain.Services.PlatesExtractionService;
import com.agencia.RegistrarAvion.Domain.Services.ViewInfoService;

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
