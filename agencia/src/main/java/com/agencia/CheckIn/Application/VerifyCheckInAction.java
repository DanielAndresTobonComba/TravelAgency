package com.agencia.CheckIn.Application;

import com.agencia.CheckIn.Domain.Service.VerifyCheckInService;

public class VerifyCheckInAction {

    VerifyCheckInService verifyCheckInService;

    public VerifyCheckInAction(VerifyCheckInService verifyCheckInService) {
        this.verifyCheckInService = verifyCheckInService;
    }

    public int verify(int connectionFlightId, int reservationId) {

        return verifyCheckInService.verifyCheckIn(connectionFlightId, reservationId);
    }

}
