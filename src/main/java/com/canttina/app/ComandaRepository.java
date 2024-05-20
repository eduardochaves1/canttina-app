package com.canttina.app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComandaRepository extends MongoRepository<Comanda, String> {
}
