package com.mahdiyeh.restfulwebservice.controller;

import com.mahdiyeh.restfulwebservice.exception.DirectorNotFoundException;
import com.mahdiyeh.restfulwebservice.model.Director;
import com.mahdiyeh.restfulwebservice.model.Movie;
import com.mahdiyeh.restfulwebservice.repository.DirectorRepository;
import com.mahdiyeh.restfulwebservice.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class MovieJpaResource {
    private final MovieRepository movieRepository;

    private final DirectorRepository directorRepository;

    @PostMapping(value = "/jpa/directors/{id}/movies")
    public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Movie movie) {

        Optional<Director> directorOptional = directorRepository.findById(id);
        if (directorOptional.isEmpty()) {
            throw new DirectorNotFoundException(".:this id {" + id + "} not found:.");
        }
        Director director = directorOptional.get();
        movie.setDirector(director);
        movieRepository.save(movie);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(movie.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
