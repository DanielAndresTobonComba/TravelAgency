package com.agencia.TipoDocumento.Main;

import java.util.List;
import com.agencia.AbstractClasses.subFuncionalidad;
import com.agencia.CasesListController.CasesListController;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.TipoDocumento.Adapter.In.menuGestioTipoDocumento;


public class MainTipoDocumento {

    public static void main(Empleado empleado) {

        // aca va la lista dinamica

        List<subFuncionalidad> lstFuncionesTipoDocumento = CasesListController.getController().lstFuncionalidadesTipoDocumento;

        menuGestioTipoDocumento menuGestioTipoDocumento = new menuGestioTipoDocumento(lstFuncionesTipoDocumento, empleado); 

        menuGestioTipoDocumento.start();




    }

}
