package com.agencia.LogIn.Application;

import java.util.List;

import com.agencia.LogIn.Domain.ViewRolService;

public class SearchRols {

    private final ViewRolService viewRolService;

    public SearchRols(ViewRolService viewRolService) {
        this.viewRolService = viewRolService;
    }

    public List<String> extract() {
        return viewRolService.extractRols();
    }

}
