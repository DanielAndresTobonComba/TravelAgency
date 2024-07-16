package com.agencia.LogIn.MainLogIn;

import com.agencia.LogIn.Adapter.In.ExtractEmployeeRepository;
import com.agencia.LogIn.Adapter.In.LogInView;
import com.agencia.LogIn.Adapter.In.ViewRolsRepository;
import com.agencia.LogIn.Application.CheckEmployee;
import com.agencia.LogIn.Application.SearchRols;
import com.agencia.LogIn.Domain.VerifyEmployeeService;
import com.agencia.LogIn.Domain.ViewRolService;

public class MainLogIn {

    public static void mainLogIn () {
        ViewRolService viewRolService = new ViewRolsRepository();
        SearchRols searchRols = new SearchRols(viewRolService);
        VerifyEmployeeService verifyEmployeeService = new ExtractEmployeeRepository();
        CheckEmployee checkEmployee = new CheckEmployee(verifyEmployeeService);
        LogInView logInView = new LogInView(searchRols, checkEmployee);



        logInView.startLogIn();

    }

}
