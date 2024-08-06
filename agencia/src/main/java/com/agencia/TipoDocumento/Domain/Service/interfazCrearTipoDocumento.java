package com.agencia.TipoDocumento.Domain.Service;

import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Domain.Entity.TipoDocumento;

public interface interfazCrearTipoDocumento {

    void crearTipoDocumento (TipoDocumento entidad , Empleado empleado);
}
