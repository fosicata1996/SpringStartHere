package main.controllers;

import main.entities.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country france = Country.of("France", 67);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favorite_food", "cheese and wine")
                .body(france);
    }

    @GetMapping("/all")
    public List<Country> all() {
        return List.of(
                Country.of("France", 64),
                Country.of("Spain", 47)
        );
    }
}
