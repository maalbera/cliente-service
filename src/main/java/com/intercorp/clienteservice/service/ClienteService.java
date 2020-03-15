package com.intercorp.clienteservice.service;

import com.intercorp.clienteservice.model.Cliente;
import com.intercorp.clienteservice.model.ClientesList;
import com.intercorp.clienteservice.model.Estadistica;
import com.intercorp.clienteservice.service.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public void creaCliente(Cliente cliente) {
        LocalDate hoy = LocalDate.now();
        LocalDate nacimiento = cliente.getFechaNaciemiento().toInstant().
                atZone(ZoneId.systemDefault()).toLocalDate();
        Long edad = ChronoUnit.YEARS.between(nacimiento, hoy);
        cliente.setEdad(edad);
        clienteRepository.save(cliente);
    }

    public List<ClientesList> listCliente() {
        final LocalDate hoy = LocalDate.now();

        List<Cliente> clientes = StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return clientes.stream().map(c ->
                new ClientesList(c,
                        Instant.ofEpochMilli(c.getFechaNaciemiento().getTime()).atZone(ZoneId.systemDefault()).toLocalDate().plusDays(c.getEdad()*365 +new Random().nextInt(15000)))).collect(Collectors.toList());
    }

    public Estadistica estadisticaCliente() {
        List<Cliente> clientes = StreamSupport.stream(clienteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        Estadistica estadistica = new Estadistica();

        Double diferencia = 0D;
        Double varianza = 0D;
        Double desviacion = 0D;

        Double promedio = clientes.stream().mapToDouble(c -> c.getEdad()).summaryStatistics().getAverage();

        diferencia = clientes.stream().mapToDouble(c -> Math.pow((c.getEdad() - promedio), 2f)).sum();
        varianza = diferencia / clientes.size();
        desviacion = Math.sqrt(varianza);
        estadistica.setDesviacion(desviacion);
        estadistica.setPromedio(promedio);
        return estadistica;
    }

}
