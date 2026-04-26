package io.github.spring.controller.adapter;

import io.github.entity.Cliente;
import io.github.entity.Endereco;
import io.github.spring.controller.dto.Request.ClienteRequest;
import io.github.spring.controller.dto.Response.ClienteResponse;
import io.github.spring.controller.dto.Response.EnderecoResponse;

import java.util.UUID;

public class ClienteControllerAdapter {
    private ClienteControllerAdapter() {
    }

    public static Cliente castRequest(ClienteRequest request) {

        Endereco endereco = new Endereco(
                request.endereco().logradouro(),
                request.endereco().numero(),
                request.endereco().cidade(),
                request.endereco().estado()
        );

        return new Cliente(
                UUID.randomUUID().toString(),
                request.nome(),
                request.dataNasc(),
                endereco
        );
    }

    public static Cliente castRequestWithId(String id, ClienteRequest request) {

        Endereco endereco = new Endereco(
                request.endereco().logradouro(),
                request.endereco().numero(),
                request.endereco().cidade(),
                request.endereco().estado()
        );

        return new Cliente(
                id,
                request.nome(),
                request.dataNasc(),
                endereco
        );
    }

    public static ClienteResponse castResponse(Cliente cliente) {

        return new ClienteResponse(
                cliente.id(),
                cliente.nome(),
                cliente.dataNasc(),
                new EnderecoResponse(
                        cliente.endereco().logradouro(),
                        cliente.endereco().numero(),
                        cliente.endereco().cidade(),
                        cliente.endereco().estado()
                )
        );
    }
}
