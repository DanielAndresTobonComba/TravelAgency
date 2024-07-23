package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente.RepoNumeroDocumento;
import com.agencia.Verifiers.CheckString;

public class ControladorNumeroDocumento {

    public void tomarNuevoNumeroDocumento (String numeroDocumento) {
        
        System.out.print("Nuevo numero de documento >>>> ");
        String nuevoNumeroDocumento = CheckString.check("Digita de nuevo el numero de documento"); 

        RepoNumeroDocumento repoNumeroDocumento = new RepoNumeroDocumento(); 

        repoNumeroDocumento.actualizarNumeroDocumento(numeroDocumento , nuevoNumeroDocumento);
    }

}
