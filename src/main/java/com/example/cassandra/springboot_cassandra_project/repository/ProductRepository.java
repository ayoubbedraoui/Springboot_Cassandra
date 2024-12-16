package com.example.cassandra.springboot_cassandra_project.repository;

import com.example.cassandra.springboot_cassandra_project.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends CassandraRepository<Product, String> {
    Optional<Product> findById(Integer id);
}
