package com.agencia.Tarifa.Domain;

import com.agencia.LogIn.Domain.Empleado;

public abstract class actualizarDatosTarifa {

    public String enunciado; 

    public abstract void actualizar (String numeroTarifa , Empleado empleado);

}
