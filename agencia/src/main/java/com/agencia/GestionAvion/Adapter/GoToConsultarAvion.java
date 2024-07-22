package com.agencia.GestionAvion.Adapter;

import com.agencia.AbstractClasses.Funcionalidad;
import com.agencia.ConsultarAvion.MainConsultarAvion.MainConsultarAvion;
import com.agencia.LogIn.Domain.Empleado;

public class GoToConsultarAvion extends Funcionalidad {

    public GoToConsultarAvion(String enunciado, String codigo) {
        this.enunciado = enunciado;
        this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainConsultarAvion.main(empleado);

    }

}
