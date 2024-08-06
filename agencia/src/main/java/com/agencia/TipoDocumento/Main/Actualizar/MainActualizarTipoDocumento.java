package com.agencia.TipoDocumento.Main.Actualizar;

import java.util.List;

import com.agencia.AbstractClasses.subFuncionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.In.Actualizar.menuActualizarTipoDocumento;

public class MainActualizarTipoDocumento {

    public static void main (Empleado empleado) {

    // aca vamos a llamar a la sub vista dinamica



        List<subFuncionalidad> lstFuncionalidadesActualizarTipoDocumento = CasesListController.getController().lstFuncionalidadesActualizarTipoDocumento;

        menuActualizarTipoDocumento menuActualizarTipoDocumento = new menuActualizarTipoDocumento(lstFuncionalidadesActualizarTipoDocumento, empleado);

        menuActualizarTipoDocumento.start();


    }
}
