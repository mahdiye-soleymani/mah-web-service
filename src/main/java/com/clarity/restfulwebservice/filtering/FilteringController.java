package com.clarity.restfulwebservice.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomBean() {
        return new SomeBean("mm", "aa", "ee");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomBean() {
        return Arrays.asList(
                new SomeBean("mm", "aa", "ee"),
                new SomeBean("mmd", "aad", "eed"));
    }
}

