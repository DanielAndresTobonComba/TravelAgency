package com.agencia.Aeropuerto.MainAeropuerto;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Aeropuerto.Infraestructure.In.IntroGestionAeropuerto;
import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;

public class MainMenuAeropuerto {

    public static void main(Empleado empleado) {

        List<Funcionalidad> listaFuncionesGestionarAeropuerto = CasesListController.getController().lstGestionarAeropuerto;

        IntroGestionAeropuerto introGestionAeropuerto = new IntroGestionAeropuerto(listaFuncionesGestionarAeropuerto, empleado);

        introGestionAeropuerto.start();

    }

}
