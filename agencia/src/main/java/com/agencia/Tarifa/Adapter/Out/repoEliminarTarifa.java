package com.agencia.Tarifa.Adapter.Out;

import com.agencia.Tarifa.Application.Casos.eliminarTarifa;
import com.agencia.Tarifa.Application.Service.InterfazEliminaTarifa;

public class repoEliminarTarifa implements InterfazEliminaTarifa {

    @Override
    public void eliminar(int numeroTarifa) {
       System.out.println("Entre a la db");
    }

    

}
