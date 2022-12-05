package com.clarity.restfulwebservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Movie {
    private Integer id;
    public String title;
    public Date releaseDate;
}
