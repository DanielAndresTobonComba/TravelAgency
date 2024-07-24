package com.agencia.CheckIn.Domain.Entity;

public class Reservation {

    private int id;
    private String fecha;
    private int Viaje_id;
    private int Tarifa_id;
    private int Cliente_id;
    private int MetodoPago_id;
    private int EstadoPago;
    private String nombrePasajero;
    private int edad;
    private String dni;
    private int TipoDocumento_id;

    public Reservation() {}

    public Reservation( String fecha, int viaje_id, int tarifa_id, int cliente_id, int metodoPago_id, int estadoPago,
            String nombrePasajero, int edad, String dni, int tipoDocumento_id) {
        this.fecha = fecha;
        this.Viaje_id = viaje_id;
        this.Tarifa_id = tarifa_id;
        this.Cliente_id = cliente_id;
        this.MetodoPago_id = metodoPago_id;
        this.EstadoPago = estadoPago;
        this.nombrePasajero = nombrePasajero;
        this.edad = edad;
        this.dni = dni;
        this.TipoDocumento_id = tipoDocumento_id;
    }

    public Reservation(int id, String fecha, int viaje_id, int tarifa_id, int cliente_id, int metodoPago_id, int estadoPago,
            String nombrePasajero, int edad, String dni, int tipoDocumento_id) {
        this.id = id;
        this.fecha = fecha;
        this.Viaje_id = viaje_id;
        this.Tarifa_id = tarifa_id;
        this.Cliente_id = cliente_id;
        this.MetodoPago_id = metodoPago_id;
        this.EstadoPago = estadoPago;
        this.nombrePasajero = nombrePasajero;
        this.edad = edad;
        this.dni = dni;
        this.TipoDocumento_id = tipoDocumento_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getViaje_id() {
        return Viaje_id;
    }

    public void setViaje_id(int viaje_id) {
        Viaje_id = viaje_id;
    }

    public int getTarifa_id() {
        return Tarifa_id;
    }

    public void setTarifa_id(int tarifa_id) {
        Tarifa_id = tarifa_id;
    }

    public int getCliente_id() {
        return Cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        Cliente_id = cliente_id;
    }

    public int getMetodoPago_id() {
        return MetodoPago_id;
    }

    public void setMetodoPago_id(int metodoPago_id) {
        MetodoPago_id = metodoPago_id;
    }

    public int getEstadoPago() {
        return EstadoPago;
    }

    public void setEstadoPago(int estadoPago) {
        EstadoPago = estadoPago;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getTipoDocumento_id() {
        return TipoDocumento_id;
    }

    public void setTipoDocumento_id(int tipoDocumento_id) {
        TipoDocumento_id = tipoDocumento_id;
    }


}
