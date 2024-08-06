package com.agencia.GestionAvion.Application;

import java.sql.ResultSet;

import com.agencia.GestionAvion.Domain.Service.SearchAirplaneService;

public class ExtractSearchAirplaneAction {

    private SearchAirplaneService searchAirplaneService;

    public ExtractSearchAirplaneAction(SearchAirplaneService searchAirplaneService) {
        this.searchAirplaneService = searchAirplaneService;
    }

    public ResultSet extract (String placa) {

        return this.searchAirplaneService.search(placa);

    }


}
