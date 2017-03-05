package com.sprint3r.deans4j;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByName(String name);
    Optional<Product> findById(Long id);
    List<Product> findAllByType(String type);
}
