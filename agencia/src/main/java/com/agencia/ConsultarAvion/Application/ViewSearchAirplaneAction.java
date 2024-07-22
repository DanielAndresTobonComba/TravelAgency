package com.agencia.ConsultarAvion.Application;

import java.sql.ResultSet;

import com.agencia.ConsultarAvion.Domain.Service.ViewSearchAirplaneService;

public class ViewSearchAirplaneAction {

    private ViewSearchAirplaneService viewSearchAirplaneService;

    public ViewSearchAirplaneAction(ViewSearchAirplaneService viewSearchAirplaneService) {
        this.viewSearchAirplaneService = viewSearchAirplaneService;
    }

    public void view(ResultSet resultSet) {

        this.viewSearchAirplaneService.view(resultSet);

    }

}
