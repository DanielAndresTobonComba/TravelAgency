package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Verifiers.CheckString;

public class ControladorNumeroDocumento {

    public void tomarNuevoNumeroDocumento () {
        
        System.out.println("Digita el nuevo numero de documento");
        String numeroDocumento = CheckString.check("Digita de nuevo el numero de documento"); 
    }

}
