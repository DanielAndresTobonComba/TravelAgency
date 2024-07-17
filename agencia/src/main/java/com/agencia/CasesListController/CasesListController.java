package com.agencia.CasesListController;

import java.util.ArrayList;
import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.EmployeeView.Domain.ActualizarAvion;
import com.agencia.EmployeeView.Domain.RegistrarAvion;
import com.agencia.IntroView.Domain.IntroLogIn;
import com.agencia.IntroView.Domain.BuyTicket;
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
        Funcionalidad buyTicket = new BuyTicket("Comprar vuelo", "");
        Funcionalidad registrarAvion = new RegistrarAvion("Registrar Avión", "rav");
        Funcionalidad actualizarAvion = new ActualizarAvion("Actualizar Avión", "aav");
        lstIntro.add(introLogin);
        lstIntro.add(buyTicket);
        lstIntro.add(logOut);
        lstFuncionalidades.add(registrarAvion);
        lstFuncionalidades.add(actualizarAvion);
    }

    public static CasesListController getController() {
        return CONTROLLER;
    }

    


}
