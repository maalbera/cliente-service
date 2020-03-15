package com.intercorp.clienteservice.api;

public class ClienteRequest {

    private String nombre;
    private String apellido;
    private String  fechaNaciemiento;

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNaciemiento(String fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNaciemiento() {
        return fechaNaciemiento;
    }
}
