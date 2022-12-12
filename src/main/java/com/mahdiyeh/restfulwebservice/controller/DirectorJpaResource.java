package com.mahdiyeh.restfulwebservice.controller;

import com.mahdiyeh.restfulwebservice.exception.DirectorNotFoundException;
import com.mahdiyeh.restfulwebservice.model.Director;
import com.mahdiyeh.restfulwebservice.model.Movie;
import com.mahdiyeh.restfulwebservice.repository.DirectorRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController()
@AllArgsConstructor
public class DirectorJpaResource {

    private final DirectorRepository directorRepository;

    @GetMapping(value = "/jpa/directors")
    public List<Director> retrieveAllDirectors() {
        return directorRepository.findAll();
    }

    @GetMapping(value = "/jpa/directors/{id}")
    public Optional<Director> director(@PathVariable int id) {
        Optional<Director> director = directorRepository.findById(id);
        if (director.isEmpty())
            throw new DirectorNotFoundException(".:this id {" + id + "} not found:.");
        return director;
    }

    @PostMapping(value = "/jpa/directors")
    public ResponseEntity<Object> creatDirector(@Valid @RequestBody Director director) {
        Director saveDirector = directorRepository.save(director);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveDirector.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/jpa/directors/{id}")
    public void deleteDirector(@PathVariable int id) {
        directorRepository.deleteById(id);
    }

    @GetMapping(value = "/jpa/directors/{id}/movies")
    public List<Movie> retrieveAllDirectorsMovies(@PathVariable int id) {
        Optional<Director> directorOptional= directorRepository.findById(id);
        if (directorOptional.isEmpty()){
            throw new DirectorNotFoundException(".:this id {" + id + "} not found:.");
        }
        return directorOptional.get().getMovies();
    }
}
