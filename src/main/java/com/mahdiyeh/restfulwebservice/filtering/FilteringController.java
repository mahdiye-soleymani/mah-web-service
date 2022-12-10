package com.mahdiyeh.restfulwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
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

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveDynamicSomBean() {
        SomeBean someBean = new SomeBean("mm", "aa", "ee");
        SimpleBeanPropertyFilter filter =SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters=new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        MappingJacksonValue mapping =new MappingJacksonValue(someBean);
        mapping.setFilters(filters);
        return mapping;
    }
}

