package com.example.HeroesApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroesController {



    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHeroes(){

    }

    @GetMapping("/heroes")
    public String getHeroes() {
      return "[{'name':'superman'}]";
    }

}
