package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorNombre;
import com.agencia.Cliente.Utilities.actualizarDatosCliente;

public class Nombre extends actualizarDatosCliente {


    public Nombre(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar(String numeroDocumento) {
        ControladorNombre controladorNombre = new ControladorNombre(); 
        controladorNombre.tomarNuevoNombre(numeroDocumento);
    }

}
