package com.agencia.Avion.Application;

import java.sql.ResultSet;
import java.util.List;

import com.agencia.Avion.Domain.Service.ViewInfoService;

public class ViewInfoModelsAction {

    private ViewInfoService viewInfoService;

    public ViewInfoModelsAction(ViewInfoService viewInfoService) {
        this.viewInfoService = viewInfoService;
    }

    public List<Integer> executeView(ResultSet resultSet) {

        return this.viewInfoService.print(resultSet);
        
    }

}
