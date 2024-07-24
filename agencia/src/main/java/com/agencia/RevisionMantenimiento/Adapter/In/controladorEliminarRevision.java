package com.agencia.RevisionMantenimiento.Adapter.In;

import com.agencia.RevisionMantenimiento.Adapter.Out.repoEliminarRevision;
import com.agencia.RevisionMantenimiento.Utilities.tomarDatosRevision;
import com.agencia.Verifiers.CheckInt;

public class controladorEliminarRevision extends tomarDatosRevision{

    @Override
    public void tomarDatos() {
        System.out.println("\n===================================");
        System.out.println("          ELIMINAR REVISIÒN");
        System.out.println("===================================");

        System.out.print("Numero revisiòn >>>> ");
        int numeroRevision = CheckInt.check("Digita de nuevo el numero de revisiòn"); 

        repoEliminarRevision eliminarRevision = new repoEliminarRevision(); 
        eliminarRevision.ejecutarEliminarRevision(numeroRevision);


    }

    

}
