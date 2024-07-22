package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorEdad;
import com.agencia.Cliente.Utilities.actualizarDatosCliente;

public class Edad extends  actualizarDatosCliente {

    public Edad(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar(String numeroDocumento) {
        ControladorEdad controladorEdad = new ControladorEdad(); 
        controladorEdad.tomarEdadNueva(numeroDocumento);
    }
}
