package com.agencia.CheckIn.Application;

import com.agencia.CheckIn.Domain.Service.ExtractAirplaneCapacityService;

public class ExtractAirplaneCapacityAction {

    ExtractAirplaneCapacityService extractAirplaneCapacityService;

    

    public ExtractAirplaneCapacityAction(ExtractAirplaneCapacityService extractAirplaneCapacityService) {
        this.extractAirplaneCapacityService = extractAirplaneCapacityService;
    }



    public int extract(int AirplaneId) {

        return this.extractAirplaneCapacityService.obtainCapacity(AirplaneId);
    }

}
