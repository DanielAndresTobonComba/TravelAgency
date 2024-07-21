package com.agencia.Tarifa.Domain;

public class Tarifa {

    private String descripcion ;
    private String detalle; 
    private Double precioBase; 
    private Double impuesto;


    public Tarifa() {
    }



    public Tarifa(String descripcion, String detalle, Double precioBase, Double impuesto) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precioBase = precioBase;
        this.impuesto = impuesto;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getDetalle() {
        return detalle;
    }



    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }



    public Double getPrecioBase() {
        return precioBase;
    }



    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }



    public Double getImpuesto() {
        return impuesto;
    }



    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    

    

}
