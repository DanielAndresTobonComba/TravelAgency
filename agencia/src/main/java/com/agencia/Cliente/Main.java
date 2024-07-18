package com.agencia.Cliente;

import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.menuActualizarCliente;

public class Main {

    
    public static void main(String[] args) {

        
/*         
        interfazConsultarCliente servicio = new repositorioConsultarCliente(); 

        ConsultarCliente consultarCliente = new ConsultarCliente(servicio); 

        controladorConsultarCliente adaptador = new controladorConsultarCliente(consultarCliente);

        adaptador.tomarDocumentoCliente();
 */


/*         interfazActualizarCliente servicio = new repositorioActualizarCliente();

        actualizarCliente actualizarCliente = new actualizarCliente(servicio); 

        controladorActualizarCliente adaptador = new controladorActualizarCliente(actualizarCliente); 

        adaptador.ejecutarActualizarCliente(); */


        menuActualizarCliente controlador = new menuActualizarCliente();

        controlador.ejecutarMenu();
        

        
    }

}
