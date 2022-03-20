package com.example.json.jsonnodedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class JsonMapperUtil {

    Logger logger = LoggerFactory.getLogger(JsonMapperUtil.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(String empId) throws IOException {
        return employeeRepository.findById(empId);
    }

    public Employee saveEmployeeById(Employee input) {
        return employeeRepository.save(input);
    }
}
