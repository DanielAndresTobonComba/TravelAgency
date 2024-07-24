package com.agencia.CheckIn.Application;

import java.util.List;

import com.agencia.CheckIn.Domain.Service.ExtractConnectionNumbersService;

public class ExtractConnectionNumbersAction {

    ExtractConnectionNumbersService extractConnectionNumbersService;

    public ExtractConnectionNumbersAction(ExtractConnectionNumbersService extractConnectionNumbersService) {
        this.extractConnectionNumbersService = extractConnectionNumbersService;
    }

    public List<String> extract(int Viaje_id) {

        return this.extractConnectionNumbersService.extractConnections(Viaje_id);

    }

}
