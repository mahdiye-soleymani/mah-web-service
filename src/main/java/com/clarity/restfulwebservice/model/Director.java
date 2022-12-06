package com.clarity.restfulwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Director {
    private Integer id;
    private String name;
    private Date birthDay;
}
