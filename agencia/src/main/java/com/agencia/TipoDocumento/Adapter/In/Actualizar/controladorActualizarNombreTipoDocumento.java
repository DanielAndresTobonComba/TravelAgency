package com.agencia.TipoDocumento.Adapter.In.Actualizar;


import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.Out.repoActualizarTipoDocumento;
import com.agencia.TipoDocumento.Application.Actualizar.actualizarNombreTipoDocumento;
import com.agencia.Verifiers.CheckInt;
import com.agencia.Verifiers.CheckString;


public class controladorActualizarNombreTipoDocumento {

    private final actualizarNombreTipoDocumento actualizarTipoDocumento;

    public controladorActualizarNombreTipoDocumento(
            com.agencia.TipoDocumento.Application.Actualizar.actualizarNombreTipoDocumento actualizarTipoDocumento) {
        this.actualizarTipoDocumento = actualizarTipoDocumento;
    }

    public void tomarDatosTipoDocumento (Empleado empleado) {

        System.out.println("Digita el tipo de documento a modificar");
        int idTipoDocumento = CheckInt.check("Digita de nuevo el tipo de documento");

        System.out.println("Digita el nuevo nombre del tipo de documento");
        String nuevoNombre = CheckString.check("Digita de nuevo el nombre del documento"); 

/*      repoActualizarTipoDocumento repoActualizarTipoDocumento = new repoActualizarTipoDocumento(); 

        repoActualizarTipoDocumento.actualizarTipoDocumento(idTipoDocumento , nuevoNombre);
 */

        actualizarTipoDocumento.ejecutarActualizarTipoDocumento(idTipoDocumento, nuevoNombre , empleado);
    }


    
}
