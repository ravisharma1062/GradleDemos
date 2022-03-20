package com.example.json.jsonnodedemo;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.Map;

@Document("Employee")
public class Employee {
    @Id
    private String id;
    private String name;
    @Field("details")
    private Map<String, Object> details;

    @JsonAnySetter
    public void add(String key, Object value) {
        if (null == details) {
            details = new HashMap<>();
        }
        details.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> get() {
        return details;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
