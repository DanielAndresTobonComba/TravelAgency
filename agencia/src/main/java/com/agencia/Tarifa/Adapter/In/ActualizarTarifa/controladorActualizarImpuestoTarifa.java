package com.agencia.Tarifa.Adapter.In.ActualizarTarifa;

import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarDescripcion;
import com.agencia.Tarifa.Adapter.Out.ActualizarTarifa.repoActualizarImpuesto;
import com.agencia.Verifiers.CheckString;

public class controladorActualizarImpuestoTarifa {

    public void tomarImpuesto (String numeroTarifa) {

        System.out.println("Digita el nuevo impuesto con este formato (0.0)");
        String nuevoImpuesto = CheckString.check("Digita de nuevo el impuesto");
        
        repoActualizarImpuesto repoActualizarImpuesto = new repoActualizarImpuesto(); 
        repoActualizarImpuesto.ejecutarActualizarImpuesto( numeroTarifa, nuevoImpuesto);


    }

}
