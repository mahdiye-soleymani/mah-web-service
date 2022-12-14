package com.mahdiyeh.restfulwebservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Director {
    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, max = 30, message = ".:The name must be between 2 and 35 characters:.")
    private String name;
//    @Past(message = ".:Choose a date in the past:.")
//    private Date birthDay;

}
