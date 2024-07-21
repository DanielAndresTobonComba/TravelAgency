package com.agencia.ActualizarAvion.Application;

import com.agencia.ActualizarAvion.Domain.Service.UpdateAirplaneService;
import com.agencia.RegistrarAvion.Domain.Entity.Airplane;

public class UpdateAirplaneAction {

    UpdateAirplaneService updateAirplaneService;

    public UpdateAirplaneAction(UpdateAirplaneService updateAirplaneService) {
        this.updateAirplaneService = updateAirplaneService;
    }

    public boolean update(Airplane airplane) {

        return this.updateAirplaneService.updateInfo(airplane);

    }

}
