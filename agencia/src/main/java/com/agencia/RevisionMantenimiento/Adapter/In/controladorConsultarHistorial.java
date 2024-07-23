package com.agencia.RevisionMantenimiento.Adapter.In;

import com.agencia.RevisionMantenimiento.Adapter.Out.repoConsultarHistorial;
import com.agencia.RevisionMantenimiento.Utilities.tomarDatosRevision;
import com.agencia.Verifiers.CheckString;

public class controladorConsultarHistorial extends tomarDatosRevision {

    @Override
    public void tomarDatos () {

        System.out.println("Digita la placa del avion");
        String placa = CheckString.check("Digita de nuevo la placa"); 

        repoConsultarHistorial consultarHistorial = new repoConsultarHistorial(); 
        consultarHistorial.ejecutarConsultarDatos(placa);

    }

}
