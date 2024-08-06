package com.agencia.GestionAvion.Adapter.In;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.GestionAvion.Main.MainActualizarCapacidad;
import com.agencia.LogIn.Domain.Empleado;

public class GoToActualizarCapacidadAvion extends Funcionalidad {

    public GoToActualizarCapacidadAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
       MainActualizarCapacidad.main(empleado);

    }

    

}
