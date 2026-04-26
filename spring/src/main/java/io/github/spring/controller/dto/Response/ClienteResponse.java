package io.github.spring.controller.dto.Response;


public record ClienteResponse(
        String id,
        String nome,
        String dtNascimento,
        EnderecoResponse endereco) {
}
