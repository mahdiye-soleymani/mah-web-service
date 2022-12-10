package com.clarity.restfulwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
//@JsonIgnoreProperties(value = {"field1","field2"})
public class SomeBean {
    private String field1;
    private String field2;
    @JsonIgnore
    private String field3;
}
