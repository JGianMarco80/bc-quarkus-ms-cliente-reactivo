package com.nttd.ms.cliente.service;

import com.nttd.ms.cliente.dto.ClienteDTO;
import com.nttd.ms.cliente.entity.Cliente;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ClienteService {

    Uni<List<Cliente>> findAll();

    Uni<Cliente> findById(String id);

    Uni<Cliente> save(Cliente cliente);

    Uni<Cliente> update(String id, Cliente cliente);

    Uni<Cliente> delete(String id);


    Uni<ClienteDTO> findByNumeroDocumento(String numeroDocumento);
}
