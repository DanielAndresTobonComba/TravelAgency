package com.agencia.CasesListController;

import java.util.ArrayList;
import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.IntroView.Domain.IntroLogIn;
import com.agencia.IntroView.Domain.Exit;

public class CasesListController {

    public static List<Funcionalidad> lstIntro;

    private static CasesListController CONTROLLER = new CasesListController();

    private CasesListController() {
        lstIntro = new ArrayList<>();
        Funcionalidad introLogin = new IntroLogIn("Iniciar Sesión", "");
        Funcionalidad logOut = new Exit("Salir", "");
        lstIntro.add(introLogin);
        lstIntro.add(logOut);
    }

    public static CasesListController getController() {
        return CONTROLLER;
    }

    


}
