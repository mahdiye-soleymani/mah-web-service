package com.clarity.restfulwebservice.controller;

import com.clarity.restfulwebservice.model.Welcome;
import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@AllArgsConstructor
public class WelcomeController {

    private final MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, path = "/welcome")
    public Welcome welcome() {
        return new Welcome("welcome to mah project");
    }

    @GetMapping(path = "/welcome/path/{year}")
    public Welcome welcomePath(@PathVariable String year) {
        return new Welcome(String.format("year: %s", year));
    }

    @GetMapping(path = "/goodMorning")
    public String goodMorning(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return messageSource.getMessage("good.morning.message", null, locale);
    }
}
