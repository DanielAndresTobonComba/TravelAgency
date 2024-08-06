package com.agencia.GestionAvion.Application;

import com.agencia.GestionAvion.Domain.Entity.Airplane;
import com.agencia.GestionAvion.Domain.Service.UpdateAirplaneService;

public class UpdateAirplaneAction {

    UpdateAirplaneService updateAirplaneService;

    public UpdateAirplaneAction(UpdateAirplaneService updateAirplaneService) {
        this.updateAirplaneService = updateAirplaneService;
    }

    public boolean update(Airplane airplane) {

        return this.updateAirplaneService.updateInfo(airplane);

    }

}
