package com.agencia.GestionAvion.Application;

import java.sql.ResultSet;

import com.agencia.GestionAvion.Domain.Service.ExtractRegistersService;

public class ExtractRegistersAction {

    private ExtractRegistersService extractRegistersService;

    public ExtractRegistersAction(ExtractRegistersService extractRegistersService) {
        this.extractRegistersService = extractRegistersService;
    }

    public ResultSet extractInfo() {

        return this.extractRegistersService.extractInfo();
    }


}
