package main.controllers;

import main.entities.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france() {
        return Country.of("France", 67);
    }

    @GetMapping("/all")
    public List<Country> all() {
        return List.of(
                Country.of("France", 64),
                Country.of("Spain", 47)
        );
    }
}
