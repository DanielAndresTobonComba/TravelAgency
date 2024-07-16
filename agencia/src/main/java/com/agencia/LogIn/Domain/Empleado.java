package com.agencia.LogIn.Domain;

import java.sql.Date;

public class Empleado {

    private int id;
    private String name, fechaIngreso, ciudad, aerolinea, rol, tipoDocumento, usuario, password;
 

    public Empleado() {}

    public Empleado(int id, String name, String ciudad, String aerolinea, String rol, String tipoDocumento,
            String usuario, String password, String fechaIngreso) {
        this.id = id;
        this.name = name;
        this.ciudad = ciudad;
        this.aerolinea = aerolinea;
        this.rol = rol;
        this.tipoDocumento = tipoDocumento;
        this.usuario = usuario;
        this.password = password;
        this.fechaIngreso = fechaIngreso;
    }

    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
 

}
