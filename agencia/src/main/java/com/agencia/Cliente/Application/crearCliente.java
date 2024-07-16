package com.agencia.Cliente.Application;

import com.agencia.Cliente.Domian.Entity.Cliente;
import com.agencia.Cliente.Domian.Service.interfazCrearCliente;

public class crearCliente {

    private final interfazCrearCliente servicio;

    public crearCliente(interfazCrearCliente servicio) {
        this.servicio = servicio;
    } 

    public void ejecutarCrearCliente (Cliente cliente) {
        servicio.crearCLiente(cliente);
    }


    
}
