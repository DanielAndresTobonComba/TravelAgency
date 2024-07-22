package com.agencia.RevisionMantenimiento.Adapter.In;

import com.agencia.RevisionMantenimiento.Adapter.Out.repoEliminarRevision;
import com.agencia.RevisionMantenimiento.Utilities.tomarDatosRevision;
import com.agencia.Verifiers.CheckInt;

public class controladorEliminarRevision extends tomarDatosRevision{

    @Override
    public void tomarDatos() {
        
        System.out.println("Digita el numero de revisiòn");
        int numeroRevision = CheckInt.check("Digita de neuvo el numero de revisiòn"); 

        repoEliminarRevision eliminarRevision = new repoEliminarRevision(); 
        eliminarRevision.ejecutarEliminarRevision(numeroRevision);


    }

    

}
