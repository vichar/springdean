package com.sprint3r.deans4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository repository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/products")
    Iterable<Product> productList() {
        return repository.findAll();
    }

    @GetMapping("/product/{id}")
    ResponseEntity<Product> getProductDetail(@PathVariable Long id) {
        Optional<Product> product = repository.findById(id);

        if (product.isPresent())
            return new ResponseEntity<>(product.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
