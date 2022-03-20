package com.example.json.jsonnodedemo;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<JsonNode, String> {
}
