package com.agencia.CasesListController;

import java.util.ArrayList;
import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.EmployeeView.Domain.RegistrarAvion;
import com.agencia.IntroView.Domain.IntroLogIn;
import com.agencia.IntroView.Domain.Exit;

public class CasesListController {

    public static List<Funcionalidad> lstIntro;
    public static List<Funcionalidad> lstFuncionalidades;

    private static CasesListController CONTROLLER = new CasesListController();

    private CasesListController() {
        lstIntro = new ArrayList<>();
        lstFuncionalidades = new ArrayList<>();
        Funcionalidad introLogin = new IntroLogIn("Iniciar Sesión", "");
        Funcionalidad logOut = new Exit("Salir", "");
        Funcionalidad registrarAvion = new RegistrarAvion("Registrar Avión", "rav");
        lstIntro.add(introLogin);
        lstIntro.add(logOut);
        lstFuncionalidades.add(registrarAvion);
    }

    public static CasesListController getController() {
        return CONTROLLER;
    }

    


}
