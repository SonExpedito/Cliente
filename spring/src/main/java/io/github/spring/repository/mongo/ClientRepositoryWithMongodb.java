package io.github.spring.repository.mongo;

import io.github.spring.repository.orm.ClienteOrmMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepositoryWithMongodb extends MongoRepository<ClienteOrmMongo, String> {
}
