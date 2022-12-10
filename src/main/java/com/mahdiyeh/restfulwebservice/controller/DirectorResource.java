package com.mahdiyeh.restfulwebservice.controller;

import com.mahdiyeh.restfulwebservice.dao.DirectorDaoService;
import com.mahdiyeh.restfulwebservice.exception.DirectorNotFoundException;
import com.mahdiyeh.restfulwebservice.model.Director;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@AllArgsConstructor
public class DirectorResource {

    //    @Autowired
    private final DirectorDaoService directorDaoService;

    @GetMapping(value = "/directors")
    public List<Director> retrieveAllDirectors() {
        return directorDaoService.findAll();
    }

    @GetMapping(value = "/directors/{id}")
    public Director director(@PathVariable int id) {

        Director director = directorDaoService.findDirector(id);

        if (director == null)
            throw new DirectorNotFoundException(".:this id { " + id + "} not found:.");
//        Resource<Director> resource = new Resource<>(director);
//
//        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllDirectors());
//        resource.add(linkTo.withRel("all-directors"));

        return director;
    }

    @PostMapping(value = "/directors")
    public ResponseEntity<Object> creatDirector(@Valid @RequestBody Director director) {
        Director saveDirector = directorDaoService.saveUser(director);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveDirector.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(value = "/directors/{id}")
    public void deleteDirector(@PathVariable int id) {
        Director director = directorDaoService.deleteDirectorById(id);
        if (director == null)
            throw new DirectorNotFoundException(".:this id { " + id + "} not found:.");

    }

}
