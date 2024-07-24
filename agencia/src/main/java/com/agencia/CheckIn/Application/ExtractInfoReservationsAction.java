package com.agencia.CheckIn.Application;

import com.agencia.CheckIn.Domain.Entity.Reservation;
import com.agencia.CheckIn.Domain.Service.ExtractInfoReservationsService;

public class ExtractInfoReservationsAction {

    ExtractInfoReservationsService extractInfoReservationsService;

    public ExtractInfoReservationsAction(ExtractInfoReservationsService extractInfoReservationsService) {
        this.extractInfoReservationsService = extractInfoReservationsService;
    }

    public Reservation extract(int id) {

        return this.extractInfoReservationsService.extractEntity(id);

    }

}
