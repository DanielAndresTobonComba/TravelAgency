package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class ControladorTipoDocumento {

    public void tomarNuevoTipoDocuemnto(){

        System.out.println("Digita el nuevo tipo de documento");
        int tipoDocumento = CheckInt.check("Digita de nuevo el tipo de documento"); 
        
    }
}
