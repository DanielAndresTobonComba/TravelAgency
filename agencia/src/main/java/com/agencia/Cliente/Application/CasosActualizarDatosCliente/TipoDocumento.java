package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.AbstractClasses.actualizarDatosCliente;
import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorTipoDocumento;

public class TipoDocumento extends actualizarDatosCliente{

    public TipoDocumento(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar() {
        ControladorTipoDocumento controladorTipoDocumento = new ControladorTipoDocumento(); 
        controladorTipoDocumento.tomarNuevoTipoDocuemnto();
    }


    
}
