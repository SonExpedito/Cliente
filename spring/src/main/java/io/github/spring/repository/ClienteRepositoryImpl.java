package io.github.spring.repository;

import io.github.entity.Cliente;
import io.github.repository.ClienteRepository;
import io.github.spring.repository.adapter.ClienteRepositoryAdapter;
import io.github.spring.repository.mongo.ClientRepositoryWithMongodb;
import io.github.spring.repository.orm.ClienteOrmMongo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClientRepositoryWithMongodb repository;

    public ClienteRepositoryImpl(ClientRepositoryWithMongodb repository) {
        this.repository = repository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        ClienteOrmMongo orm = ClienteRepositoryAdapter.castEntity(cliente);
        ClienteOrmMongo ormSave = repository.save(orm);
        return ClienteRepositoryAdapter.castOrm(ormSave);
    }

    @Override
    public List<Cliente> listar() {
        return repository.findAll()
                .stream()
                .map(ClienteRepositoryAdapter::castOrm)
                .toList();
    }

    @Override
    public Optional<Cliente> buscarPorId(String id) {
        return repository.findById(id)
                .map(ClienteRepositoryAdapter::castOrm);
    }

    @Override
    public void deletar(String id) {
        repository.deleteById(id);
    }
}
