package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente.RepoUsuario;
import com.agencia.Verifiers.CheckString;

public class ControladorUsuario {

    public void tomarNuevoUsuario (String numeroDocumento) {

        System.out.println("Nuevo usuario >>>> ");
        String usuario = CheckString.check("Digita de nuevo el usuario"); 

        RepoUsuario repoUsuario = new RepoUsuario(); 
        repoUsuario.actualizarNombreUsuario(numeroDocumento , usuario);
        
    }

}
