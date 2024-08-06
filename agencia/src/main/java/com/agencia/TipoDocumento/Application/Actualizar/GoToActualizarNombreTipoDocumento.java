package com.agencia.TipoDocumento.Application.Actualizar;

import com.agencia.AbstractClasses.subFuncionalidad;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.In.Actualizar.menuActualizarTipoDocumento;
import com.agencia.TipoDocumento.Main.Actualizar.MainActualizarNombreTipoDocumento;
import com.agencia.TipoDocumento.Main.Actualizar.MainActualizarTipoDocumento;

public class GoToActualizarNombreTipoDocumento extends subFuncionalidad{

    public GoToActualizarNombreTipoDocumento(String enunciado) {
        this.enunciado = enunciado;
    
        }


    @Override
    public void ejecutar(Empleado empleado) {
       MainActualizarNombreTipoDocumento.main(empleado);
    }

}
