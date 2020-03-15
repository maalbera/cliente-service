package com.intercorp.clienteservice.controller;

import com.intercorp.clienteservice.api.ClienteRequest;
import com.intercorp.clienteservice.api.EstadisticaClienteResponse;
import com.intercorp.clienteservice.api.ListClienteResponse;
import com.intercorp.clienteservice.model.Cliente;
import com.intercorp.clienteservice.model.ClientesList;
import com.intercorp.clienteservice.model.Estadistica;
import com.intercorp.clienteservice.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Api(tags = "Cliente Service")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");

    @Autowired
    private ClienteService clienteService;

    @ApiOperation(value = "Crear Cliente")
    @PostMapping("/creaCliente")
    public void creaCliente(ClienteRequest request) throws ParseException {
        Cliente cliente = new Cliente();
        cliente.setNombre(request.getNombre());
        cliente.setApellido(request.getApellido());
        cliente.setFechaNaciemiento(sdf.parse(request.getFechaNaciemiento()));
        clienteService.creaCliente(cliente);
    }

    @ApiOperation(value = "Listar Clientes")
    @GetMapping("/listCliente")
    public ListClienteResponse listCliente() {
        List<ClientesList> clientesLists = clienteService.listCliente();
        ListClienteResponse response = new ListClienteResponse();
        response.setClientes(clientesLists);
        return response;
    }

    @ApiOperation(value = "Estadisticas de Clientes")
    @GetMapping("/kpideclientes")
    public EstadisticaClienteResponse estadisticaCliente() {
        Estadistica estadistica = clienteService.estadisticaCliente();
        EstadisticaClienteResponse response = new EstadisticaClienteResponse();
        response.setDesviacion(estadistica.getDesviacion());
        response.setPromedio(estadistica.getPromedio());
        return response;
    }

}
