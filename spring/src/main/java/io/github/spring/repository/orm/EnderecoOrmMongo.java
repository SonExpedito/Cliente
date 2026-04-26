package io.github.spring.repository.orm;

public record EnderecoOrmMongo(
        String logradouro,
        String numero,
        String cidade,
        String estado
) {
}
