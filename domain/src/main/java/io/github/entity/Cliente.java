package io.github.entity;

public record Cliente(
        String id,
        String nome,
        String dataNasc,
        Endereco endereco) {
}
