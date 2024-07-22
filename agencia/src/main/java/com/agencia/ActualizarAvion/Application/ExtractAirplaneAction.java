package com.agencia.ActualizarAvion.Application;

import com.agencia.ActualizarAvion.Domain.Service.ExtractAirplaneService;
import com.agencia.RegistrarAvion.Domain.Entity.Airplane;

public class ExtractAirplaneAction {

    private ExtractAirplaneService extractAirplaneService;

    

    public ExtractAirplaneAction(ExtractAirplaneService extractAirplaneService) {
        this.extractAirplaneService = extractAirplaneService;
    }



    public Airplane extract(String placa) {

        return this.extractAirplaneService.extractAirplane(placa);

    }

}
