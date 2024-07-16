package com.agencia.Aeropuerto.Domain.Entity;

public class Aeropuerto {

    public String codigo = "caero";
    public String enunciado = "Crear aeropuerto";

    public String nombre ; 
    public int idCiudad;
    public String numAeropuerto;


    public Aeropuerto() {
    }

    


    public Aeropuerto(String codigo, String enunciado, String nombre, int idCiudad, String numAeropuerto) {
        this.codigo = codigo;
        this.enunciado = enunciado;
        this.nombre = nombre;
        this.idCiudad = idCiudad;
        this.numAeropuerto = numAeropuerto;
    }




    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getEnunciado() {
        return enunciado;
    }
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getIdCiudad() {
        return idCiudad;
    }
    public void setIdCiudad(int idCiudad) {
        this.idCiudad = idCiudad;
    }
    public String getNumAeropuerto() {
        return numAeropuerto;
    }
    public void setNumAeropuerto(String numAeropuerto) {
        this.numAeropuerto = numAeropuerto;
    }

    


}
