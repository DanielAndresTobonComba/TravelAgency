package com.agencia.RegistrarAvion.Application;

import java.sql.ResultSet;
import java.util.List;

import com.agencia.RegistrarAvion.Domain.Services.ViewInfoService;

public class ViewInfoModelsAction {

    private ViewInfoService viewInfoService;

    public ViewInfoModelsAction(ViewInfoService viewInfoService) {
        this.viewInfoService = viewInfoService;
    }

    public List<Integer> executeView(ResultSet resultSet) {

        return this.viewInfoService.print(resultSet);
        
    }

}
