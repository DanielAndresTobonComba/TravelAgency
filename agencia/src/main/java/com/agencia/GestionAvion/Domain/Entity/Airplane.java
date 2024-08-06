package com.agencia.GestionAvion.Domain.Entity;

public class Airplane {

    private int id;
    private String placa;
    private int capacidad;
    private String fechaFabricacion;
    private int ModeloAvion_id;
    private int Estado_id;

    

    public Airplane() {}

    



    public Airplane(String placa, int capacidad, String fechaFabricacion, int modeloAvion_id, int estado_id) {
        this.placa = placa;
        this.capacidad = capacidad;
        this.fechaFabricacion = fechaFabricacion;
        this.ModeloAvion_id = modeloAvion_id;
        this.Estado_id = estado_id;
    }





    public Airplane(int id, String placa, int capacidad, String fechaFabricacion, int modeloAvion_id, int estado_id) {
        this.id = id;
        this.placa = placa;
        this.capacidad = capacidad;
        this.fechaFabricacion = fechaFabricacion;
        this.ModeloAvion_id = modeloAvion_id;
        this.Estado_id = estado_id;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getPlaca() {
        return placa;
    }



    public void setPlaca(String placa) {
        this.placa = placa;
    }



    public int getCapacidad() {
        return capacidad;
    }



    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }



    public String getFechaFabricacion() {
        return fechaFabricacion;
    }



    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }



    public int getModeloAvion_id() {
        return ModeloAvion_id;
    }



    public void setModeloAvion_id(int modeloAvion_id) {
        ModeloAvion_id = modeloAvion_id;
    }



    public int getEstado_id() {
        return Estado_id;
    }



    public void setEstado_id(int estado_id) {
        Estado_id = estado_id;
    }

    

    

}
