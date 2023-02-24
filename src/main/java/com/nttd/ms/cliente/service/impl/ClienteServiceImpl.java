package com.nttd.ms.cliente.service.impl;

import com.nttd.ms.cliente.dto.ClienteDTO;
import com.nttd.ms.cliente.entity.Cliente;
import com.nttd.ms.cliente.repository.ClienteRepository;
import com.nttd.ms.cliente.service.ClienteService;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository clienteRepository;

    @Override
    public Uni<List<Cliente>> findAll() {
        return clienteRepository.listAll().onItem().transform(c -> {
            List<Cliente> cli = new ArrayList<>();
            for (Cliente cliente: c) {
                if(cliente.getEstado().equals("1")) {
                    cli.add(cliente);
                }
            }
            return cli;
        });
    }

    @Override
    public Uni<Cliente> findById(String id) {
        return clienteRepository.findById(new ObjectId(id));
    }

    @Override
    public Uni<Cliente> save(Cliente cliente) {
        return clienteRepository.persist(cliente);
    }

    @Override
    public Uni<Cliente> update(String id, Cliente cliente) {
        return clienteRepository.findById(new ObjectId(id))
                .flatMap(c -> {
                    c.setTipoCliente(cliente.getTipoCliente());
                    c.setTipoDocumento(cliente.getTipoDocumento());
                    c.setNumeroDocumento(cliente.getNumeroDocumento());
                    c.setNombreRazonSocial(cliente.getNombreRazonSocial());
                    c.setFechaNacimientoCreacion(cliente.getFechaNacimientoCreacion());
                    return Uni.createFrom().item(c);
                }).call(cl -> clienteRepository.update(cl));
    }

    @Override
    public  Uni<Cliente> delete(String id) {
        return clienteRepository.findById(new ObjectId(id))
                .flatMap(c -> {
                    c.setEstado("0");
                    return Uni.createFrom().item(c);
                }).call(cl -> clienteRepository.update(cl));
    }

    @Override
    public Uni<ClienteDTO> findByNumeroDocumento(String numeroDocumento) {
        return this.findAll().onItem().transform(clientes -> {
            ClienteDTO cliente = new ClienteDTO();
            for (Cliente c: clientes) {
                if(c.getNumeroDocumento().equals(numeroDocumento)) {
                    cliente.setTipoCliente(c.getTipoCliente());
                    cliente.setTipoDocumento(c.getTipoDocumento());
                    cliente.setNumeroDocumento(c.getNumeroDocumento());
                    cliente.setNombreRazonSocial(c.getNombreRazonSocial());
                }
            }
            return cliente;
        });
    }
}
