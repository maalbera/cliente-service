package com.intercorp.clienteservice.model;

import java.time.LocalDate;
import java.util.Date;

public class ClientesList {

    private Cliente cliente;
    private LocalDate fechaMuerte;

    public ClientesList(Cliente cliente, LocalDate fechaMuerte) {
        this.cliente = cliente;
        this.fechaMuerte = fechaMuerte;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setFechaMuerte(LocalDate fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public LocalDate getFechaMuerte() {
        return fechaMuerte;
    }
}
