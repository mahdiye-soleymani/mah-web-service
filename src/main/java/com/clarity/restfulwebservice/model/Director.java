package com.clarity.restfulwebservice.model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class Director {
    private Integer id;
    @Size(min = 2, max = 30, message = ".:The name must be between 2 and 35 characters:.")
    private String name;
    @Past(message = ".:Choose a date in the past:.")
    private Date birthDay;

}
