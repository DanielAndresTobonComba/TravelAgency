package com.agencia.RegistrarAvion.Application;

import java.sql.ResultSet;

import com.agencia.RegistrarAvion.Domain.Services.ExtractRegistersService;

public class ExtractRegistersAction {

    private ExtractRegistersService extractRegistersService;

    public ExtractRegistersAction(ExtractRegistersService extractRegistersService) {
        this.extractRegistersService = extractRegistersService;
    }

    public ResultSet extractInfo() {

        return this.extractRegistersService.extractInfo();
    }


}
