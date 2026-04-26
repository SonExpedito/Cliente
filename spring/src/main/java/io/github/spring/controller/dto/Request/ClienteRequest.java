package io.github.spring.controller.dto.Request;

public record ClienteRequest(
        String id,
        String nome,
        String dataNasc,
        EnderecoRequest endereco) {
}
