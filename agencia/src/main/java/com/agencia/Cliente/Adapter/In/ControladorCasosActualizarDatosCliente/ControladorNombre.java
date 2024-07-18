package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Verifiers.CheckString;

public class ControladorNombre {

    public void tomarNuevoNombre () {
        
        System.out.println("Digita el nuevo nombre");
        String nombre = CheckString.check("Digita de nuevo el nombre"); 
    }

}
