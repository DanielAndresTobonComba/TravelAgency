package com.agencia.CheckIn.Application;

import com.agencia.CheckIn.Domain.Service.TakeChairService;

public class TakeChairAction {

    private TakeChairService takeChairService;



    public TakeChairAction(TakeChairService takeChairService) {
        this.takeChairService = takeChairService;
    }


    public int insert(String chair, int connectionFlightId, int reservationId) {

        return this.takeChairService.takeChair(chair, connectionFlightId, reservationId);

    }

}
