package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.AbstractClasses.actualizarDatosCliente;
import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorEdad;

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
