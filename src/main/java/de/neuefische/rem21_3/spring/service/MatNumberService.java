package de.neuefische.rem21_3.spring.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MatNumberService {

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
