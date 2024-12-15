package com.example.cassandra.springboot_cassandra_project;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResouceNotFoundException extends RuntimeException{
    public ResouceNotFoundException(String message) {
        super(message);
    }
}
