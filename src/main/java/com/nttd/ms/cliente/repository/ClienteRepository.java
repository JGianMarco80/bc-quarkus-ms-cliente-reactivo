package com.nttd.ms.cliente.repository;

import com.nttd.ms.cliente.entity.Cliente;
//import io.quarkus.mongodb.panache.PanacheMongoRepository;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements ReactivePanacheMongoRepository<Cliente> {
}
