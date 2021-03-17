package com.example.HeroesApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroesController {

  List<HeroesDto> heroeslist = new ArrayList<HeroesDto>();

    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHeroes(@RequestBody HeroesDto heroesDto){
      heroeslist.add(heroesDto);

    }

    @GetMapping("/heroes")
    public List<HeroesDto> getHeroes() {
      return this.heroeslist;
    }

}
