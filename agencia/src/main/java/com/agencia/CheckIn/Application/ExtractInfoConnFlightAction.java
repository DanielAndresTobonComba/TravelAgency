package com.agencia.CheckIn.Application;

import com.agencia.CheckIn.Domain.Entity.ConnectionFlight;
import com.agencia.CheckIn.Domain.Service.ExtractInfoConnFlightService;

public class ExtractInfoConnFlightAction {

    ExtractInfoConnFlightService extractInfoConnFlightService;

    public ExtractInfoConnFlightAction(ExtractInfoConnFlightService extractInfoConnFlightService) {
        this.extractInfoConnFlightService = extractInfoConnFlightService;
    }

    public ConnectionFlight extract(String connectionNumber) {

        return this.extractInfoConnFlightService.extractEntity(connectionNumber);
    }

}
