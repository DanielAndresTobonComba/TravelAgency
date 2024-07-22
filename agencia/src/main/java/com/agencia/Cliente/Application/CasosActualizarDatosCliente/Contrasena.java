package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorContrasena;
import com.agencia.Cliente.Utilities.actualizarDatosCliente;

public class Contrasena extends actualizarDatosCliente{

    public Contrasena(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar(String numeroDocumento) {
        
        ControladorContrasena controladorContrasena = new ControladorContrasena();
        controladorContrasena.tomarNuevaContraseña(numeroDocumento);
        
    }

}
