package com.agencia.TipoDocumento.Adapter.In;


import com.agencia.TipoDocumento.Adapter.Out.repoActualizarTipoDocumento;
import com.agencia.TipoDocumento.Application.actualizarTipoDocumento;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;


public class controladorActualizarTipoDocumento {

    private final actualizarTipoDocumento actualizarTipoDocumento;

    
    public controladorActualizarTipoDocumento(
            com.agencia.TipoDocumento.Application.actualizarTipoDocumento actualizarTipoDocumento) {
        this.actualizarTipoDocumento = actualizarTipoDocumento;
    }


    public void tomarDatosTipoDocumento () {


        System.out.println("Digita el tipo de documento a modificar");
        int idTipoDocumento = CheckInt.check("Digita de nuevo el tipo de documento");



        System.out.println("Digita el nuevo nombre del tipo de documento");
        String nuevoNombre = CheckString.check("Digita de nuevo el nombre del documento"); 

        repoActualizarTipoDocumento repoActualizarTipoDocumento = new repoActualizarTipoDocumento(); 

        repoActualizarTipoDocumento.actualizarTipoDocumento(idTipoDocumento , nuevoNombre);

    }


    
}
