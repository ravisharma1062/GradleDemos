package com.example.json.jsonnodedemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/json")
public class JsonNodeDemoApplication {

	@Autowired
	private JsonMapperUtil jsonMapperUtil;

	public static void main(String[] args) {
		SpringApplication.run(JsonNodeDemoApplication.class, args);
	}

	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> fetchEmployee(@PathVariable("empId") String empId) {
		JsonNode jsonNode = null;
		try {
			jsonNode = jsonMapperUtil.getEmployeeById(empId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(jsonNode, HttpStatus.OK);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> saveEmployee(@RequestBody Map<Object, Object> input) {
		JsonNode jsonNode = null;
		jsonNode = jsonMapperUtil.saveEmployeeById(input);
		return new ResponseEntity<>(jsonNode, HttpStatus.OK);
	}

}
