package com.agencia.GestionAvion.Application;

import java.sql.ResultSet;

import com.agencia.GestionAvion.Domain.Service.ViewSearchAirplaneService;

public class ViewSearchAirplaneAction {

    private ViewSearchAirplaneService viewSearchAirplaneService;

    public ViewSearchAirplaneAction(ViewSearchAirplaneService viewSearchAirplaneService) {
        this.viewSearchAirplaneService = viewSearchAirplaneService;
    }

    public void view(ResultSet resultSet) {

        this.viewSearchAirplaneService.view(resultSet);

    }

}
