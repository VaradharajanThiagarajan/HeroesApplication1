package com.example.HeroesApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeroesController {

    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHeroes(){

    }

}
