package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Verifiers.CheckString;

public class ControladorContrasena {

    public void tomarNuevaContraseña () {

        System.out.println("Digita la nueva contraseña");
        String contraseña = CheckString.check("Digita de nuevo la contraseña"); 

        

    }

}
