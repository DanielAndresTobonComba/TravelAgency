package com.agencia.Avion.Adapter.In;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.Avion.Main.MainActualizarEstado;
import com.agencia.LogIn.Domain.Empleado;

public class GoToActualizarEstadoAvion extends Funcionalidad {

    public GoToActualizarEstadoAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainActualizarEstado.main(empleado);

    }

}
