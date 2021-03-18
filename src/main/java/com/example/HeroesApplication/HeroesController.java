package com.example.HeroesApplication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HeroesController {

  HeroService heroService;

  public HeroesController(HeroService heroService)
  {
    this.heroService = heroService;
  }

    @PostMapping("/heroes")
    @ResponseStatus(HttpStatus.CREATED)
    public void addHeroes(@RequestBody HeroesDto heroesDto){

      this.heroService.create(heroesDto);

    }

    @GetMapping("/heroes")
    public List<HeroesDto> getHeroes() {
      return this.heroService.fetchAll();
    }

  @GetMapping("/heroesByName")
  public List<HeroesDto> getHeroesByName(@RequestParam(value = "name") String name) {
    return this.heroService.findByname(name);
  }

}
