package com.agencia.Cliente;

import com.agencia.Cliente.Adapter.In.controladorConsultarCliente;
import com.agencia.Cliente.Adapter.In.controladorCrearCliente;
import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.menuActualizarCliente;
import com.agencia.Cliente.Adapter.Out.repositorioConsultarCliente;
import com.agencia.Cliente.Adapter.Out.repositorioCrearCliente;
import com.agencia.Cliente.Application.ConsultarCliente;
import com.agencia.Cliente.Application.crearCliente;
import com.agencia.Cliente.Domian.Service.interfazConsultarCliente;
import com.agencia.Cliente.Domian.Service.interfazCrearCliente;

public class MainCliente {

    
    public static void main(String[] args) {

 /*        interfazCrearCliente servicio = new repositorioCrearCliente(); 

        crearCliente crearCliente = new crearCliente(servicio);

        controladorCrearCliente adaptador = new controladorCrearCliente(crearCliente); 

        adaptador.ejecutarcrearCliente();  */

        
      
/*         interfazConsultarCliente servicio = new repositorioConsultarCliente(); 

        ConsultarCliente consultarCliente = new ConsultarCliente(servicio); 

        controladorConsultarCliente adaptador = new controladorConsultarCliente(consultarCliente);

        adaptador.tomarDocumentoCliente(); */
 



        menuActualizarCliente controlador = new menuActualizarCliente();

        controlador.ejecutarMenu();  
        

        
    }

}
