package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente.RepoContrasena;
import com.agencia.Verifiers.CheckString;

public class ControladorContrasena {

    public void tomarNuevaContraseña (String numeroDocumento) {

        System.out.println("Digita la nueva contraseña");
        String contraseña = CheckString.check("Digita de nuevo la contraseña"); 

        RepoContrasena repoContrasena = new RepoContrasena(); 
        repoContrasena.actualizarContraseña( numeroDocumento , contraseña);

        

    }

}
