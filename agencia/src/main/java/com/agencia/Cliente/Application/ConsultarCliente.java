package com.agencia.Cliente.Application;

import com.agencia.Cliente.Domian.Entity.Cliente;
import com.agencia.Cliente.Domian.Service.interfazConsultarCliente;

public class ConsultarCliente {

    private final interfazConsultarCliente servicio ;


    public ConsultarCliente(interfazConsultarCliente servicio) {
        this.servicio = servicio;
    } 

    

    public void ejecutarConsultarAeropuerto (String numeroDocumento){
        servicio.consultarCliente(numeroDocumento);
    }
}
