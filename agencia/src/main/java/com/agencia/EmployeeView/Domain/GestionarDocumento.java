package com.agencia.EmployeeView.Domain;

import com.agencia.AbstractClasses.Funcionalidad;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Main.MainTipoDocumento;

public class GestionarDocumento extends Funcionalidad {

    public GestionarDocumento(String enunciado, String codigo) {
    this.enunciado = enunciado;
    this.codigo = codigo;
    }



    @Override
    public void ejecutar(Empleado empleado) {
        
        MainTipoDocumento.main(empleado);

    }

}
