package com.agencia.Avion.Application;

import com.agencia.Avion.Domain.Entity.Airplane;
import com.agencia.Avion.Domain.Service.ExtractAirplaneService;

public class ExtractAirplaneAction {

    private ExtractAirplaneService extractAirplaneService;

    

    public ExtractAirplaneAction(ExtractAirplaneService extractAirplaneService) {
        this.extractAirplaneService = extractAirplaneService;
    }



    public Airplane extract(String placa) {

        return this.extractAirplaneService.extractAirplane(placa);

    }

}
