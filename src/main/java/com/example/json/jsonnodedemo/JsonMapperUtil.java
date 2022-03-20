package com.example.json.jsonnodedemo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Map;

@Service
public class JsonMapperUtil {

    Logger logger = LoggerFactory.getLogger(JsonMapperUtil.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    private ObjectMapper objectMapper = null;

    public JsonMapperUtil() {
        objectMapper = new ObjectMapper();
    }

    private String jsonStr = "{\n" +
            "\t\"id\":\"123\",\n" +
            "\t\"name\":\"Ravi Sharma\",\n" +
            "\t\"address\": {\n" +
            "\t\t\"country\":\"India\",\n" +
            "\t\t\"state\":\"Bihar\",\n" +
            "\t\t\"city\":\"Chapra\"\n" +
            "\t}\n" +
            "}";

    public JsonNode getEmployeeById(String empId) throws IOException {
        JsonNode emp = objectMapper.readTree(jsonStr);
        logger.info(emp.path("name").textValue());
        return emp;
    }

    public JsonNode saveEmployeeById(Map<Object, Object> input) {
        JsonNode jsonNode = objectMapper.convertValue(input, JsonNode.class);
        employeeRepository.save(jsonNode);
        logger.info(jsonNode.path("name").textValue());
        return jsonNode;
    }
}
