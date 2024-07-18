package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class ControladorEdad {

    public void tomarEdadNueva () {
        
        System.out.println("Digita la nueva edad");
        int edad = CheckInt.check("Digita de nuevo la edad"); 
    }

}
