package com.example.cassandra.springboot_cassandra_project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("products")

public class Product {

    @PrimaryKey
    private int id;
    private String name;
    private Double price;

    public Product() {}
    public Product(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for price
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
