package com.agencia.CheckIn.Domain.Entity;

public class ConnectionFlight {

    private int id;
    private String numerConexion;
    private int idAeropuertoOrigen;
    private int Viaje_id;
    private int Avion_id;
    private int idAeropuertoDestino;

    public ConnectionFlight() {}

    public ConnectionFlight(String numerConexion, int idAeropuertoOrigen, int viaje_id, int avion_id, int idAeropuertoDestino) {
        this.numerConexion = numerConexion;
        this.idAeropuertoOrigen = idAeropuertoOrigen;
        this.Viaje_id = viaje_id;
        this.Avion_id = avion_id;
        this.idAeropuertoDestino = idAeropuertoDestino;
    }

    public ConnectionFlight(int id, String numerConexion, int idAeropuertoOrigen, int viaje_id, int avion_id, int idAeropuertoDestino) {
        this.id = id;
        this.numerConexion = numerConexion;
        this.idAeropuertoOrigen = idAeropuertoOrigen;
        this.Viaje_id = viaje_id;
        this.Avion_id = avion_id;
        this.idAeropuertoDestino = idAeropuertoDestino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumerConexion() {
        return numerConexion;
    }

    public void setNumerConexion(String numerConexion) {
        this.numerConexion = numerConexion;
    }

    public int getIdAeropuertoOrigen() {
        return idAeropuertoOrigen;
    }

    public void setIdAeropuertoOrigen(int idAeropuertoOrigen) {
        this.idAeropuertoOrigen = idAeropuertoOrigen;
    }

    public int getViaje_id() {
        return Viaje_id;
    }

    public void setViaje_id(int viaje_id) {
        Viaje_id = viaje_id;
    }

    public int getAvion_id() {
        return Avion_id;
    }

    public void setAvion_id(int avion_id) {
        Avion_id = avion_id;
    }

    

    
    

    

}
