package com.agencia.RegistrarAvion.Application;

import com.agencia.RegistrarAvion.Domain.Entity.Airplane;
import com.agencia.RegistrarAvion.Domain.Services.AirplaneRecordService;

public class RecordAirplaneAction {

    private AirplaneRecordService airplaneRecordService;

    public RecordAirplaneAction(AirplaneRecordService airplaneRecordService) {
        this.airplaneRecordService = airplaneRecordService;
    }

    public int executeRecord(Airplane airplane) {

        return this.airplaneRecordService.record(airplane);
    }

}
