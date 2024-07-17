package com.agencia.Cliente;

import com.agencia.Aeropuerto.Application.consultarAeropuerto;
import com.agencia.Aeropuerto.Application.eliminarAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazConsultarAeropuerto;
import com.agencia.Aeropuerto.Domain.Service.interfazEliminarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorConsultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.In.controladorEliminarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioConsultarAeropuerto;
import com.agencia.Aeropuerto.Infraestructure.Out.repositorioEliminarAeropuerto;
import com.agencia.Cliente.Application.ConsultarCliente;
import com.agencia.Cliente.Domian.Service.interfazConsultarCliente;
import com.agencia.Cliente.Infraestructure.In.controladorConsultarCliente;
import com.agencia.Cliente.Infraestructure.Out.repositorioConsultarCliente;

public class Main {

    
    public static void main(String[] args) {
        
        interfazConsultarCliente servicio = new repositorioConsultarCliente(); 

        ConsultarCliente consultarCliente = new ConsultarCliente(servicio); 

        controladorConsultarCliente adaptador = new controladorConsultarCliente(consultarCliente);

        adaptador.tomarDocumentoCliente();



        
    }

}
