package com.clarity.restfulwebservice.controller;

import com.clarity.restfulwebservice.model.Hello;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(method = RequestMethod.GET, path = "/mah")
    public Hello hello() {
        return new Hello("mah");
    }

    @GetMapping(path = "/mah/path/{age}")
    public Hello helloPath(@PathVariable String age) {
        return new Hello(String.format("age: %s",age));
    }
}
