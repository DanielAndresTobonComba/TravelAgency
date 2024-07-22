package com.agencia.ActualizarAvion.MainActualizarAvion;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.ActualizarAvion.Adapter.In.IntroViewUpdateAirplane;
import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;

public class MainActualizarAvion {

    public static void main(Empleado empleado) {

        List<Funcionalidad> listaFuncionesActualizarAvion = CasesListController.getController().lstActualizarAvion;

        IntroViewUpdateAirplane introViewUpdateAirplane = new IntroViewUpdateAirplane(listaFuncionesActualizarAvion, empleado);
        introViewUpdateAirplane.start();

    }

}
