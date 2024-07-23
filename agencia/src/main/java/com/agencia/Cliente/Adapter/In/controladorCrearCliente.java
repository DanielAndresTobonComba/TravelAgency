package com.agencia.Cliente.Adapter.In;

import com.agencia.Aeropuerto.Application.actualizarAeropuerto;
import com.agencia.Cliente.Adapter.Out.repositorioCrearCliente;
import com.agencia.Cliente.Application.crearCliente;
import com.agencia.Cliente.Domian.Entity.Cliente;
import com.agencia.Cliente.Domian.Service.interfazCrearCliente;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckPassword;
import com.agencia.Verifiers.CheckString;

public class controladorCrearCliente {

    private final crearCliente crearCliente;

    

    public controladorCrearCliente(com.agencia.Cliente.Application.crearCliente crearCliente) {
        this.crearCliente = crearCliente;
    }



    public void ejecutarcrearCliente () {


        Cliente cliente = new Cliente();

        System.out.println("===================================");
        System.out.println("          CREAR CLIENTE");
        System.out.println("===================================");

        System.out.print("Digite el nombre >>>> ");
        
        String nombre = CheckString.check("Digite de nuevo el nombre");

        System.out.print("Digite la edad >>>> ");
        int edad = CheckInt.check("Digite de nuevo la edad");

        System.out.print("Digita el id del tipo del documento >>>> ");
        int tipoDocumento = CheckInt.check("Digita de nuevo el id de tipo del documento");


        System.out.print("Digita el documento del cliente >>>> ");
        String numeroDocumento = CheckString.check("Digita el documento ");

        System.out.print("Digita el usuario del cliente >>>> ");
        String usuario = CheckString.check("Digita de nuevo el usuario >>>>"); 

        String contraseña = CheckPassword.check();



        cliente.setNombre(nombre);
        cliente.setEdad(edad);
        cliente.setNumeroDocumento(numeroDocumento);
        cliente.setTipoDocumento(tipoDocumento);
        cliente.setUsuario(usuario);
        cliente.setContraseña(contraseña);


        repositorioCrearCliente repositorioCrearCLiente = new repositorioCrearCliente();

        repositorioCrearCLiente.crearCLiente(cliente);


    }

    

}
