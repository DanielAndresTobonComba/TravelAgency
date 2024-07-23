package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente.RepoContrasena;
import com.agencia.Verifiers.CheckPassword;
import com.agencia.Verifiers.CheckString;

public class ControladorContrasena {

    public void tomarNuevaContraseña (String numeroDocumento) {

      
        String contraseña = CheckPassword.check(); 

        RepoContrasena repoContrasena = new RepoContrasena(); 
        repoContrasena.actualizarContraseña( numeroDocumento , contraseña);

        

    }

}
