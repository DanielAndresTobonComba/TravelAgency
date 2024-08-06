package com.agencia.GestionAvion.Application;

import com.agencia.GestionAvion.Domain.Entity.Airplane;
import com.agencia.GestionAvion.Domain.Service.ExtractAirplaneService;

public class ExtractAirplaneAction {

    private ExtractAirplaneService extractAirplaneService;

    

    public ExtractAirplaneAction(ExtractAirplaneService extractAirplaneService) {
        this.extractAirplaneService = extractAirplaneService;
    }



    public Airplane extract(String placa) {

        return this.extractAirplaneService.extractAirplane(placa);

    }

}
