package com.agencia.RevisionMantenimiento.Domain;
import java.util.Date;

public class revision {

    private Date fecha;
    private String placaAvion; 
    private String descripcion;


    public revision() {
    }


    public revision(Date fecha, String placaAvion, String descripcion) {
        this.fecha = fecha;
        this.placaAvion = placaAvion;
        this.descripcion = descripcion;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public String getPlacaAvion() {
        return placaAvion;
    }


    public void setPlacaAvion(String placaAvion) {
        this.placaAvion = placaAvion;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    

    

}
