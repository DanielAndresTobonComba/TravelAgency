package com.agencia.Avion.Application;

import com.agencia.Avion.Domain.Entity.Airplane;
import com.agencia.Avion.Domain.Service.UpdateAirplaneService;

public class UpdateAirplaneAction {

    UpdateAirplaneService updateAirplaneService;

    public UpdateAirplaneAction(UpdateAirplaneService updateAirplaneService) {
        this.updateAirplaneService = updateAirplaneService;
    }

    public boolean update(Airplane airplane) {

        return this.updateAirplaneService.updateInfo(airplane);

    }

}
