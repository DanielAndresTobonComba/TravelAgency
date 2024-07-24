package com.agencia.RevisionMantenimiento.Domain;

public class revision {

    private String fecha;
    private String placaAvion; 
    private String descripcion;


    public revision() {
    }


    public revision(String fecha, String placaAvion, String descripcion) {
        this.fecha = fecha;
        this.placaAvion = placaAvion;
        this.descripcion = descripcion;
    }


    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
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
