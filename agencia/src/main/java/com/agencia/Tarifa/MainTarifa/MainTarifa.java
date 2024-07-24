package com.agencia.Tarifa.MainTarifa;

import java.util.List;

import com.agencia.AbstractClasses.Funcionalidad;

import com.agencia.Aeropuerto.Infraestructure.In.IntroGestionAeropuerto;
import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.Tarifa.Adapter.In.menuTarifa;


public class MainTarifa {

    public static void main(Empleado empleado) {
        
        List<Funcionalidad> lst = CasesListController.getController().lstFuncionalidadesTarifa;

        menuTarifa introGestionTarifa = new menuTarifa(lst, empleado);

        introGestionTarifa.ejecutarMenu();

        
    }

}
