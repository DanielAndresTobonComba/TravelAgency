package com.agencia.LogIn.Adapter.In;

import java.util.List;

import com.agencia.LogIn.Application.SearchRols;
import com.agencia.LogIn.Domain.VerifyEmployeeService;
import com.agencia.LogIn.Domain.ViewRolService;

public class LogInView {

    private final SearchRols searchRols;

    public LogInView(SearchRols searchRols) {
        this.searchRols = searchRols;
    }

    public void startLogIn() {
        List<String> rols = this.searchRols.extract();

        for (String rol : rols ) {
            System.out.println(rol);
        }
        
        
    }

}
