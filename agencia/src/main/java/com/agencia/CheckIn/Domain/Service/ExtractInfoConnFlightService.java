package com.agencia.CheckIn.Domain.Service;

import com.agencia.CheckIn.Domain.Entity.ConnectionFlight;

public interface ExtractInfoConnFlightService {

    public ConnectionFlight extractEntity (String connectionNumber);

}
