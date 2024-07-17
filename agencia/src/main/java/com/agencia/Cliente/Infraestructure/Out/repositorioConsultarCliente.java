package com.agencia.Cliente.Infraestructure.Out;

import com.agencia.Cliente.Domian.Entity.Cliente;
import com.agencia.Cliente.Domian.Service.interfazConsultarCliente;

public class repositorioConsultarCliente implements interfazConsultarCliente {

    @Override
    public void consultarCliente(Cliente cliente) {
        System.out.println("Entre a la db");
    }

}
