package com.mahdiyeh.restfulwebservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Director director;

    public Movie(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Movie() {
    }
}
