package com.agencia.GestionAvion.Domain.Service;

import java.sql.ResultSet;

public interface SearchAirplaneService {

    public ResultSet search(String placa);

}
