package com.intercorp.clienteservice.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

public class ClienteRequest {

    private String nombre;
    private String apellido;

    @ApiModelProperty(required = true,example = "01/01/1950")
    @JsonFormat(pattern = "dd/MM/YYYY")
    private String  fechaNaciemiento;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNaciemiento(String fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNaciemiento() {
        return fechaNaciemiento;
    }
}
