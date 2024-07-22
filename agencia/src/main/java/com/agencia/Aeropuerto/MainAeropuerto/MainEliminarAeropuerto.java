package com.agencia.Aeropuerto.MainAeropuerto;

import com.agencia.Aeropuerto.Application.eliminarAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazEliminarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorEliminarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioEliminarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class MainEliminarAeropuerto {

    public static void main(Empleado empleado) {

        interfazEliminarAeropuerto eliminoAeropuertoRepositorio = new repositorioEliminarAeropuerto();
        eliminarAeropuerto eliminarAeropuerto = new eliminarAeropuerto(eliminoAeropuertoRepositorio);
        controladorEliminarAeropuerto controladorEliminarAeropuerto = new controladorEliminarAeropuerto(eliminarAeropuerto, empleado);
        controladorEliminarAeropuerto.tomarNumAeropuerto();
        
    }

}
