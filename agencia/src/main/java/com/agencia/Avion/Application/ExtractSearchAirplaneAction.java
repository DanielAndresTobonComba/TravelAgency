package com.agencia.Avion.Application;

import java.sql.ResultSet;

import com.agencia.Avion.Domain.Service.SearchAirplaneService;

public class ExtractSearchAirplaneAction {

    private SearchAirplaneService searchAirplaneService;

    public ExtractSearchAirplaneAction(SearchAirplaneService searchAirplaneService) {
        this.searchAirplaneService = searchAirplaneService;
    }

    public ResultSet extract (String placa) {

        return this.searchAirplaneService.search(placa);

    }


}
