package com.example.cassandra.springboot_cassandra_project;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.example.repository") // Remplacez par le package de vos repositories
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Override
    protected String getKeyspaceName() {
        return "products_keyspace"; // Remplacez par le nom de votre keyspace
    }

    @Override
    protected String getContactPoints() {
        return "127.0.0.1"; // Adresse de votre serveur Cassandra
    }

    @Override
    protected int getPort() {
        return 9042; // Port par défaut de Cassandra
    }

    @Override
    protected String getLocalDataCenter() {
        return "datacenter1"; // Nom du datacenter, vérifié via `SELECT data_center FROM system.local`
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.example.cassandra.springboot_cassandra_project.model"}; // Remplacez par le package contenant vos entités Cassandra
    }
}
