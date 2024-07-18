package com.agencia.Cliente.Application.CasosActualizarDatosCliente;

import com.agencia.AbstractClasses.actualizarDatosCliente;
import com.agencia.Cliente.Adapter.In.ControladorCasosActualizarDatosCliente.ControladorUsuario;

public class Usuario extends actualizarDatosCliente{

    public Usuario(String atributo) {
        this.atributo = atributo;

    }

    @Override
    public void actualizar(String numeroDocumento) {
        ControladorUsuario controladorUsuario = new ControladorUsuario(); 
        controladorUsuario.tomarNuevoUsuario();
    }




}
