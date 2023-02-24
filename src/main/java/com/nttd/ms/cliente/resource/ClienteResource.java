package com.nttd.ms.cliente.resource;

import com.nttd.ms.cliente.dto.ClienteDTO;
import com.nttd.ms.cliente.entity.Cliente;
import com.nttd.ms.cliente.service.ClienteService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/cliente")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteResource {

    @Inject
    ClienteService clienteService;

    @GET
    public Uni<List<Cliente>> findAll() {
        return clienteService.findAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Cliente> findAll(@PathParam("id") String id) {
        return clienteService.findById(id);
    }

    @POST
    @Transactional
    public Uni<Cliente> save(Cliente cliente){
        return clienteService.save(cliente);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Uni<Cliente> update(@PathParam("id") String id, Cliente cliente){
        return clienteService.update(id, cliente);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public  Uni<Cliente> delete(@PathParam("id") String id){
        return clienteService.delete(id);
    }

    @GET
    @Path("/numero-documento")
    public Uni<ClienteDTO> findByNumeroDocumento(@QueryParam("numeroDocumento") String numeroDocumento) {
        return clienteService.findByNumeroDocumento(numeroDocumento);
    }
}
