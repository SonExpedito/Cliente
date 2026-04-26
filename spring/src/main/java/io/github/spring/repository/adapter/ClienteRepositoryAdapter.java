package io.github.spring.repository.adapter;

import io.github.entity.Cliente;
import io.github.entity.Endereco;
import io.github.spring.repository.orm.ClienteOrmMongo;
import io.github.spring.repository.orm.EnderecoOrmMongo;

public class ClienteRepositoryAdapter {

    public static Cliente castOrm(ClienteOrmMongo orm) {
        return new Cliente(
                orm.id(),
                orm.nome(),
                orm.dataNasc(),
                new Endereco(
                        orm.endereco().logradouro(),
                        orm.endereco().numero(),
                        orm.endereco().cidade(),
                        orm.endereco().estado()));
    }

    public static ClienteOrmMongo castEntity(Cliente entity) {
        return new ClienteOrmMongo(
                entity.id(),
                entity.nome(),
                entity.dataNasc(),
                new EnderecoOrmMongo(
                        entity.endereco().logradouro(),
                        entity.endereco().numero(),
                        entity.endereco().cidade(),
                        entity.endereco().estado()));
    }
}
