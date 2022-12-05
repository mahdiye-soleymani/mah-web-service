package com.clarity.restfulwebservice.dao;

import com.clarity.restfulwebservice.model.Director;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class DirectorDaoService {
    private static List<Director> directors = new ArrayList<>();
    private int idCount = 3;

    static {
        directors.add(new Director(1, "Nolan", new Date()));
        directors.add(new Director(2, "Hitchcock", new Date()));
        directors.add(new Director(3, "Coppola", new Date()));
    }

    public List<Director> findAll() {
        return directors;
    }

    public Director findADirector(int id) {
        for (Director director : directors) {
            if (director.getId() == (id)) {
                return director;
            }
        }
        return null;
    }

    public Director saveUser(Director director) {
        if (director.getId() == null) {
            director.setId(++idCount);
        }
        directors.add(director);
        return director;
    }


}
