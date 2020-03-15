package com.intercorp.clienteservice.service.repository;

import com.intercorp.clienteservice.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente,Integer> {

}
