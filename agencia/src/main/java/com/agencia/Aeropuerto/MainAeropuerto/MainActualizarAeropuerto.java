package com.agencia.Aeropuerto.MainAeropuerto;

import com.agencia.Aeropuerto.Application.actualizarAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazActualizarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorActualizarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioActualizarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class MainActualizarAeropuerto {

    public static void main(Empleado empleado) {
        
        interfazActualizarAeropuerto  actualizoAeropuertoRepositorio = new repositorioActualizarAeropuerto();
        actualizarAeropuerto actualizarAeropuerto = new actualizarAeropuerto(actualizoAeropuertoRepositorio);
        controladorActualizarAeropuerto controladorActualizarAeropuerto = new controladorActualizarAeropuerto(actualizarAeropuerto, empleado);
        controladorActualizarAeropuerto.actualizarAeropuerto();

    }

}
