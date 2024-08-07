package com.agencia.Avion.Domain.Service;

import java.sql.ResultSet;
import java.util.List;

public interface ViewInfoService {

    public List<Integer> print(ResultSet resultSet);

}
