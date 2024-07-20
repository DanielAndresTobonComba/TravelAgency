package com.agencia.Aeropuerto.MainAeropuerto;

import com.agencia.Aeropuerto.Application.crearAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazCrearAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorCrearAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioCrearAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class MainCrearAeropuerto {

    public static void main (Empleado empleado) {

        interfazCrearAeropuerto registroAeropuertoRepositorio = new repositorioCrearAeropuerto();
        crearAeropuerto registrarAeropuerto = new crearAeropuerto(registroAeropuertoRepositorio);
        controladorCrearAeropuerto controladorCrearAeropuerto = new controladorCrearAeropuerto(registrarAeropuerto, empleado);
        controladorCrearAeropuerto.tomarDatosAeropuerto();

    }

}
