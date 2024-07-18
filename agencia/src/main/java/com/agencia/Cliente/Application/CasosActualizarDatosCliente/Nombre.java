package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.AbstractClasses.actualizarDatosCliente;
import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorNombre;

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
