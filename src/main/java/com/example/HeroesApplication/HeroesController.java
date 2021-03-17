package com.example.HeroesApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroesController {

  List<Heroes> heroeslist = new ArrayList<Heroes>();

    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHeroes(@RequestBody Heroes heroes){
      heroeslist.add(heroes);

    }

    @GetMapping("/heroes")
    public List<Heroes> getHeroes() {
      return this.heroeslist;
    }

}
