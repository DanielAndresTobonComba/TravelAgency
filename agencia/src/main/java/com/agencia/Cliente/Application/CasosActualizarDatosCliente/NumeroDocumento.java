package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.AbstractClasses.actualizarDatosCliente;
import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorNumeroDocumento;

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
