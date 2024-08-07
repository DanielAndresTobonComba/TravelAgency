package com.agencia.Avion.Application;

import java.sql.ResultSet;

import com.agencia.Avion.Domain.Service.ExtractRegistersService;

public class ExtractRegistersAction {

    private ExtractRegistersService extractRegistersService;

    public ExtractRegistersAction(ExtractRegistersService extractRegistersService) {
        this.extractRegistersService = extractRegistersService;
    }

    public ResultSet extractInfo() {

        return this.extractRegistersService.extractInfo();
    }


}
