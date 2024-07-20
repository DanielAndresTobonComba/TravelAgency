package com.agencia.TipoDocumento.Adapter.In;

import com.agencia.Aeropuerto.Application.eliminarAeropuerto;
import com.agencia.TipoDocumento.Application.eliminarTipoDocumento;
import com.agencia.Verifiers.CheckInt;

public class controladorEliminarTipoDocumento {

    private final eliminarTipoDocumento eliminarTipoDocumento;

    public controladorEliminarTipoDocumento(
            com.agencia.TipoDocumento.Application.eliminarTipoDocumento eliminarTipoDocumento) {
        this.eliminarTipoDocumento = eliminarTipoDocumento;
    }

    
    public void ejecutarEliminarTipoDocumento () {

        System.out.println("Digita el tipo de documento a eliminar");

        int numeroDocumento = CheckInt.check("Digita de nuevo el numero del tipo del documento");

        eliminarTipoDocumento.ejecutarELiminarTipoDocumento(numeroDocumento);
    }


}
