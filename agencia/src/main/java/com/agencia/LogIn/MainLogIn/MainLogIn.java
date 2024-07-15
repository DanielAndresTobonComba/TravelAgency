package com.agencia.LogIn.MainLogIn;

import com.agencia.LogIn.Adapter.In.LogInView;
import com.agencia.LogIn.Adapter.In.ViewRolsRepository;
import com.agencia.LogIn.Application.SearchRols;
import com.agencia.LogIn.Domain.ViewRolService;

public class MainLogIn {

    public static void mainLogIn () {
        ViewRolService viewRolService = new ViewRolsRepository();
        SearchRols searchRols = new SearchRols(viewRolService);
        LogInView logInView = new LogInView(searchRols);

        logInView.startLogIn();

    }

}
