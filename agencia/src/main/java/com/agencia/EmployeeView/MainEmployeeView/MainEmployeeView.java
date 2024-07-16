package com.agencia.EmployeeView.MainEmployeeView;

import com.agencia.EmployeeView.Adapter.In.EmployeeFunctionsRepository;
import com.agencia.EmployeeView.Adapter.In.EmployeeView;
import com.agencia.EmployeeView.Application.GeneratedMenu;
import com.agencia.EmployeeView.Domain.MenuGenerated;
import com.agencia.LogIn.Domain.Empleado;

public class MainEmployeeView {

    

    public static void mainEmployeeView(Empleado empleado) {

        MenuGenerated menuGenerated = new EmployeeFunctionsRepository(); 
        GeneratedMenu generatedMenu = new GeneratedMenu(menuGenerated);
        EmployeeView employeeView = new EmployeeView(empleado, generatedMenu);

        employeeView.generateView();



    }

}
