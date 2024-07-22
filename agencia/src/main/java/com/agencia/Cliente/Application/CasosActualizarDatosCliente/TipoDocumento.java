package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorTipoDocumento;
import com.agencia.Cliente.Utilities.actualizarDatosCliente;

public class TipoDocumento extends actualizarDatosCliente{

    public TipoDocumento(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar(String numeroDocumento) {
        ControladorTipoDocumento controladorTipoDocumento = new ControladorTipoDocumento(); 
        controladorTipoDocumento.tomarNuevoTipoDocuemnto(numeroDocumento);
    }


    
}
