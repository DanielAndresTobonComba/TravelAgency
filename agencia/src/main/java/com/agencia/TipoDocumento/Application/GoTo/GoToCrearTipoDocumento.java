package com.agencia.TipoDocumento.Application.GoTo;

import com.agencia.AbstractClasses.subFuncionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Main.MainCrearTipoDocumento;

public class GoToCrearTipoDocumento extends subFuncionalidad {
    
    public GoToCrearTipoDocumento(String enunciado) {
        this.enunciado = enunciado;

    }

    @Override
    public void ejecutar(Empleado empleado) {
        MainCrearTipoDocumento.main(empleado);
    }

}
