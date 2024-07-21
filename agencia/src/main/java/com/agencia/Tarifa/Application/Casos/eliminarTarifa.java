package com.agencia.Tarifa.Application.Casos;
import com.agencia.Tarifa.Application.Service.InterfazEliminaTarifa;

public class eliminarTarifa  {

    private final InterfazEliminaTarifa servicio ;

    public eliminarTarifa(InterfazEliminaTarifa servicio) {
        this.servicio = servicio;
    }

    
    public void tomarNumeroTarifa (int numeroTarifa){

        servicio.eliminar(numeroTarifa);
    }
    



    

    
}
