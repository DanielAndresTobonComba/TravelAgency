package com.agencia.Cliente.Adapter.In;

import com.agencia.Cliente.Application.ConsultarCliente;
import com.agencia.Cliente.Domian.Entity.Cliente;
import com.agencia.Verifiers.CheckString;

public class controladorConsultarCliente {

    private final ConsultarCliente consultarCliente;

    

    public controladorConsultarCliente(ConsultarCliente consultarCliente) {
        this.consultarCliente = consultarCliente;
    }



    public void tomarDocumentoCliente() {


        System.out.println("===================================");
        System.out.println("          CONSULTAR CLIENTE");
        System.out.println("===================================");

        System.out.print("Documento >>>> ");
        String numero = CheckString.check("Digita de nuevo el documento");

        consultarCliente.ejecutarConsultarAeropuerto(numero);
    }

}
