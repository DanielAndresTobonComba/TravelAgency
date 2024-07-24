package com.agencia.CheckIn.Application;

import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractReservationsService;

public class ExtractReservationsAction {

    ExtractReservationsService extractReservationsService;

    public ExtractReservationsAction(ExtractReservationsService extractReservationsService) {
        this.extractReservationsService = extractReservationsService;
    }

    public List<Integer> extract() {

        return this.extractReservationsService.extractCodes();

    }

}
