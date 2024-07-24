package com.agencia.CheckIn.Application;

import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractReservedChairsService;

public class ExtractReservedChairsAction {

    ExtractReservedChairsService extractReservedChairsService;

    public ExtractReservedChairsAction(ExtractReservedChairsService extractReservedChairsService) {
        this.extractReservedChairsService = extractReservedChairsService;
    }

    public List<String> extract(String connectionFlight) {

        return this.extractReservedChairsService.extractChairs(connectionFlight);
    }

}
