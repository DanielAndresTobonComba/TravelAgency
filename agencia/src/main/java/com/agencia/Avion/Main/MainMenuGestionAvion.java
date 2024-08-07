package com.agencia.Avion.Main;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Avion.Adapter.In.IntroGestionAvion;
import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;

public class MainMenuGestionAvion {

    public static void main(Empleado empleado) {

        List<Funcionalidad> listaFuncionesGestionarAvion = CasesListController.getController().lstGestionarAvion;

        IntroGestionAvion introGestionAvion = new IntroGestionAvion(listaFuncionesGestionarAvion, empleado);
        
        introGestionAvion.start();

    }

}
