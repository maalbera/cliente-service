package com.intercorp.clienteservice.api;

import com.intercorp.clienteservice.model.ClientesList;

import java.util.List;

public class ListClienteResponse {

    private List<ClientesList> clientes;

    public void setClientes(List<ClientesList> clientes) {
        this.clientes = clientes;
    }

    public List<ClientesList> getClientes() {
        return clientes;
    }
}
