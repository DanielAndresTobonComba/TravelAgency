package com.agencia.GestionAvion.Application;

import com.agencia.GestionAvion.Domain.Entity.Airplane;
import com.agencia.GestionAvion.Domain.Service.AirplaneRecordService;

public class RecordAirplaneAction {

    private AirplaneRecordService airplaneRecordService;

    public RecordAirplaneAction(AirplaneRecordService airplaneRecordService) {
        this.airplaneRecordService = airplaneRecordService;
    }

    public int executeRecord(Airplane airplane) {

        return this.airplaneRecordService.record(airplane);
    }

}
