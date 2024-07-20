package com.agencia.Aeropuerto.MainAeropuerto;

import com.agencia.Aeropuerto.Application.consultarAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazConsultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorConsultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioConsultarAeropuerto;
import com.agencia.LogIn.Domain.Empleado;

public class MainConsultarAeropuerto {

    public static void main(Empleado empleado) {

        interfazConsultarAeropuerto consultoAeropuertoRepositorio = new repositorioConsultarAeropuerto();
        consultarAeropuerto consultarAeropuerto = new consultarAeropuerto(consultoAeropuertoRepositorio);
        controladorConsultarAeropuerto controladorConsultarAeropuerto = new controladorConsultarAeropuerto(consultarAeropuerto, empleado);
        controladorConsultarAeropuerto.tomarNumAeropuerto();
        
    }

}
