package com.example.json.jsonnodedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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
	public ResponseEntity<?> fetchEmployee(@PathVariable("empId") String empId) throws IOException {
		return new ResponseEntity<>(jsonMapperUtil.getEmployeeById(empId), HttpStatus.OK);
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee input) {
		return new ResponseEntity<>(jsonMapperUtil.saveEmployeeById(input), HttpStatus.OK);
	}

}
