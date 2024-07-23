package com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.Out.imprimirTablaTipoDocumento;
import com.agencia.Cliente.Adapter.Out.RepositoriosActualizarDatosCliente.RepoTipoDocumento;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;

public class ControladorTipoDocumento {

    public void tomarNuevoTipoDocuemnto(String numeroDocumento){

        imprimirTablaTipoDocumento.imprimir();

        System.out.print("Nuevo tipo de documento >>>> ");
        String NuevoTipoDocumento = CheckString.check("Digita de nuevo el tipo de documento"); 

        

        RepoTipoDocumento repoTipoDocumento = new RepoTipoDocumento(); 
        repoTipoDocumento.actualizarTipoDocumento(numeroDocumento,  NuevoTipoDocumento);
    }
}
