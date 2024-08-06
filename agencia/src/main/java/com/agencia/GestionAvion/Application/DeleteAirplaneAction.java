package com.agencia.GestionAvion.Application;

import com.agencia.GestionAvion.Domain.Service.AirplaneDeleteService;

public class DeleteAirplaneAction {

    private AirplaneDeleteService airplaneDeleteService;

    public DeleteAirplaneAction(AirplaneDeleteService airplaneDeleteService) {
        this.airplaneDeleteService = airplaneDeleteService;
    }

    public boolean executeDeletion(String placa) {

        return this.airplaneDeleteService.delete(placa);

    }

}
