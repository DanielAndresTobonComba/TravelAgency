package com.agencia.ConsultarAvion.Domain.Service;

import java.sql.ResultSet;

public interface SearchAirplaneService {

    public ResultSet search(String placa);

}
