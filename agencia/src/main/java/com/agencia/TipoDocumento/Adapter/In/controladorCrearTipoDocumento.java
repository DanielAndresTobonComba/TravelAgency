package com.agencia.TipoDocumento.Adapter.In;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.Out.repoCrearTipoDocumento;
import com.agencia.TipoDocumento.Application.crearTipoDocumento;
import com.agencia.TipoDocumento.Domain.Entity.TipoDocumento;
import com.agencia.Verifiers.CheckString;

public class controladorCrearTipoDocumento {

    private final crearTipoDocumento crearTipoDocumento;

    public controladorCrearTipoDocumento(com.agencia.TipoDocumento.Application.crearTipoDocumento crearTipoDocumento) {
        this.crearTipoDocumento = crearTipoDocumento;
    } 

    
    public void tomarDatos (Empleado empleado) {

        System.out.println("Digita el nombre del tipo de documento");
        String nombre = CheckString.check("Digita de nuevo el nombre del tipo de documento");

        TipoDocumento documento = new TipoDocumento(); 

        documento.setNombre(nombre);

/*         repoCrearTipoDocumento repoCrearTipoDocumento = new repoCrearTipoDocumento(); 

        repoCrearTipoDocumento.crearTipoDocumento(documento); */

        crearTipoDocumento.ejecutarCrearTipoDocumento(documento , empleado);

        




    }



}
