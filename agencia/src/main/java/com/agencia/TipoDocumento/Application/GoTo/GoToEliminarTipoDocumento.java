package com.agencia.TipoDocumento.Application.GoTo;

import com.agencia.AbstractClasses.subFuncionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Main.MainEliminarTipoDocumento;

public class GoToEliminarTipoDocumento extends subFuncionalidad {

    public GoToEliminarTipoDocumento(String enunciado) {
    this.enunciado = enunciado;

    }

    @Override
    public void ejecutar(Empleado empleado) {
        MainEliminarTipoDocumento.main(empleado);
    }

}
