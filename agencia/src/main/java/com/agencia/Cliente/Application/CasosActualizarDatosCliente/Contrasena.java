package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.AbstractClasses.actualizarDatosCliente;
import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorContrasena;

public class Contrasena extends actualizarDatosCliente{

    public Contrasena(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar() {
        
        ControladorContrasena controladorContrasena = new ControladorContrasena();
        controladorContrasena.tomarNuevaContraseña();
        
    }

}
