package io.github.repository;

import io.github.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Cliente salvar(Cliente cliente);

    Optional<Cliente> buscarPorId(String id);

    List<Cliente> listar();

    void deletar(String id);
}
