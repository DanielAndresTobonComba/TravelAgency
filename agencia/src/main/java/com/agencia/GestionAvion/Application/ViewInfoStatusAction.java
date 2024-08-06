package com.agencia.GestionAvion.Application;

import java.sql.ResultSet;
import java.util.List;

import com.agencia.GestionAvion.Domain.Service.ViewInfoService;

public class ViewInfoStatusAction {

    private ViewInfoService viewInfoService;

    public ViewInfoStatusAction(ViewInfoService viewInfoService) {
        this.viewInfoService = viewInfoService;
    }

    public List<Integer> executeView(ResultSet resultSet) {

        return this.viewInfoService.print(resultSet);
        
    }

}
