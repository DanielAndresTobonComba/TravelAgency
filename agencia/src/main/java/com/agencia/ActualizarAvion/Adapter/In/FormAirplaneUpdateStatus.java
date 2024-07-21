package com.agencia.ActualizarAvion.Adapter.In;

import com.agencia.ActualizarAvion.Application.UpdateAirplaneAction;
import com.agencia.LogIn.Domain.Empleado;
import com.agencia.RegistrarAvion.Application.ExtractRegistersAction;
import com.agencia.RegistrarAvion.Application.ViewInfoStatusAction;
import com.agencia.RegistrarAvion.Domain.Entity.Airplane;

public class FormAirplaneUpdateStatus {

    private ExtractRegistersAction extractRegistersAction;
    private ViewInfoStatusAction viewInfoStatusAction;
    private UpdateAirplaneAction updateAirplaneAction;
    public FormAirplaneUpdateStatus(ExtractRegistersAction extractRegistersAction,
            ViewInfoStatusAction viewInfoStatusAction, UpdateAirplaneAction updateAirplaneAction) {
        this.extractRegistersAction = extractRegistersAction;
        this.viewInfoStatusAction = viewInfoStatusAction;
        this.updateAirplaneAction = updateAirplaneAction;
    }

    public void start(Empleado empleado, Airplane airplane) {

        

    }

}
