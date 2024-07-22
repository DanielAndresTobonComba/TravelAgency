package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorNumeroDocumento;
import com.agencia.Cliente.Utilities.actualizarDatosCliente;

public class NumeroDocumento extends actualizarDatosCliente{

    public NumeroDocumento(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar(String numeroDocumento) {
        ControladorNumeroDocumento controladorNumeroDocumento = new ControladorNumeroDocumento(); 
        controladorNumeroDocumento.tomarNuevoNumeroDocumento(numeroDocumento);
    }


    

}
