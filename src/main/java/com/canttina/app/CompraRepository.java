package com.canttina.app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompraRepository extends MongoRepository<Compra, String> {
}
