package com.agencia.Avion.Application;

import com.agencia.Avion.Domain.Entity.Airplane;
import com.agencia.Avion.Domain.Service.AirplaneRecordService;

public class RecordAirplaneAction {

    private AirplaneRecordService airplaneRecordService;

    public RecordAirplaneAction(AirplaneRecordService airplaneRecordService) {
        this.airplaneRecordService = airplaneRecordService;
    }

    public int executeRecord(Airplane airplane) {

        return this.airplaneRecordService.record(airplane);
    }

}
