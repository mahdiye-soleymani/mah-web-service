package com.clarity.restfulwebservice.controller;

import com.clarity.restfulwebservice.dao.DirectorDaoService;
import com.clarity.restfulwebservice.exception.DirectorNotFoundException;
import com.clarity.restfulwebservice.model.Director;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
@AllArgsConstructor
public class DirectorResource {

    //    @Autowired
    private final DirectorDaoService directorDaoService;

    @GetMapping(value = "/all-director")
    public List<Director> directorList() {
        return directorDaoService.findAll();
    }

    @GetMapping(value = "/directors/{id}")
    public Director director(@PathVariable int id) {

        Director director = directorDaoService.findADirector(id);

        if (director == null)
            throw new DirectorNotFoundException("id-" + id);

        return director;
    }

    @PostMapping(value = "/directors")
    public ResponseEntity<Object> creatDirector(@RequestBody Director director) {
        Director saveDirector = directorDaoService.saveUser(director);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(saveDirector.getId()).toUri();
       return ResponseEntity.created(location).build();
    }

}
