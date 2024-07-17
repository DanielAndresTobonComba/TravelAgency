package com.agencia.Cliente.Infraestructure.In;

import com.agencia.Cliente.Application.ConsultarCliente;
import com.agencia.Cliente.Domian.Entity.Cliente;

public class controladorConsultarCliente {

    private final ConsultarCliente consultarCliente;

    

    public controladorConsultarCliente(ConsultarCliente consultarCliente) {
        this.consultarCliente = consultarCliente;
    }



    public void tomarDocumentoCliente() {

        System.out.println("Tomar datos del ingreso");



        Cliente cliente = new Cliente();
        consultarCliente.ejecutarConsultarAeropuerto(cliente);
    }

}
