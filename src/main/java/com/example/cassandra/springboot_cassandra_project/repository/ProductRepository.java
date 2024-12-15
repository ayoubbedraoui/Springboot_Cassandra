package com.example.cassandra.springboot_cassandra_project.repository;

import com.example.cassandra.springboot_cassandra_project.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductRepository extends CassandraRepository<Product, Integer> {

}
