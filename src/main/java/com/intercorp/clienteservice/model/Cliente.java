package com.intercorp.clienteservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private Long edad;
    private Date fechaNaciemiento;

    public Cliente(){
        super();
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public void setFechaNaciemiento(Date fechaNaciemiento) {
        this.fechaNaciemiento = fechaNaciemiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNaciemiento() {
        return fechaNaciemiento;
    }

    public Long getEdad() {
        return edad;
    }

    public Integer getId() {
        return id;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }
}
