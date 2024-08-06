package com.agencia.TipoDocumento.Application.GoTo;

import com.agencia.AbstractClasses.subFuncionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Main.Actualizar.MainActualizarTipoDocumento;


public class GoToActualizarTipoDocumento extends subFuncionalidad {

    public GoToActualizarTipoDocumento(String enunciado) {
    this.enunciado = enunciado;

    }

    @Override
    public void ejecutar(Empleado empleado) {
        MainActualizarTipoDocumento.main(empleado);
    }

}
