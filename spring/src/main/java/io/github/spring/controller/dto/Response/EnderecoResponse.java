package io.github.spring.controller.dto.Response;

public record EnderecoResponse(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {
}
