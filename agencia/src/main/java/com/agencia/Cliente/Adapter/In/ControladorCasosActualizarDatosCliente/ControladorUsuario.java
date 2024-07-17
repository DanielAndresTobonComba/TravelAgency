package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Verifiers.CheckString;

public class ControladorUsuario {

    public void tomarNuevoUsuario () {

        System.out.println("Digita el nuevo usuario");
        String usuario = CheckString.check("Digita de nuevo el usuario"); 
        
    }

}
