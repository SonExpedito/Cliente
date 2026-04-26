package io.github.spring.controller.dto.Request;

public record EnderecoRequest(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {
}
