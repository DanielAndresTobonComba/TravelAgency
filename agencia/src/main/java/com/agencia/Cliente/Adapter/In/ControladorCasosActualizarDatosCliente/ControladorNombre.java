package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente.RepoNombre;
import com.agencia.Verifiers.CheckString;

public class ControladorNombre {

    public void tomarNuevoNombre (String numeroDocumento) {
        
        System.out.println("Digita el nuevo nombre");
        String nombre = CheckString.check("Digita de nuevo el nombre"); 

        RepoNombre repoNombre = new RepoNombre();
        repoNombre.actualizarNombre(nombre , numeroDocumento);
    }

}
