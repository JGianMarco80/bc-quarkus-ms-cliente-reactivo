package com.nttd.ms.cliente.entity;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import java.time.LocalDate;

@MongoEntity(collection = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private ObjectId id;

    //1: natural
    //2: juridica
    private String tipoCliente;

    //1: DNI
    //2: Carnet de extranjería
    //3: RUC
    private String tipoDocumento;

    private String numeroDocumento;

    private String nombreRazonSocial;

    private LocalDate fechaNacimientoCreacion;

    private String estado = "1";
}
