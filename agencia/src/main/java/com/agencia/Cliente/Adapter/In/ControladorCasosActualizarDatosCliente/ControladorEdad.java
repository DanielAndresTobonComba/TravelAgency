package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente.RepoEdad;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class ControladorEdad {

    public void tomarEdadNueva (String numeroDocumento) {
        
        System.out.println("Digita la nueva edad");
        String edad = CheckString.check("Digita de nuevo la edad"); 

        RepoEdad repoEdad = new RepoEdad(); 
        repoEdad.actualizarEdad(edad , numeroDocumento);
    }

}
