package com.sprint3r.deans4j;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private String description;
    private double price;

    protected Product() {
    }

    public Product(String name, String type, String description, double price) {
        this(null, name, type, description, price);
    }

    Product(Long id, String name, String type, String description, double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.price = price;
    }
}
