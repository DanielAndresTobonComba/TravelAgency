package com.agencia.EliminarAvion.Application;

import com.agencia.EliminarAvion.Domain.Service.AirplaneDeleteService;

public class DeleteAirplaneAction {

    private AirplaneDeleteService airplaneDeleteService;

    public DeleteAirplaneAction(AirplaneDeleteService airplaneDeleteService) {
        this.airplaneDeleteService = airplaneDeleteService;
    }

    public boolean executeDeletion(String placa) {

        return this.airplaneDeleteService.delete(placa);

    }

}
