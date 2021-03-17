package com.example.HeroesApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeroService {
    private final HeroRepository heroRepository;
    @Autowired
    public HeroService(HeroRepository heroRepository)
    {
        this.heroRepository = heroRepository;
    }

    public void create(HeroesDto heroDto)
    {
        heroRepository.save(new HeroEntity(heroDto.getName()));
    }
}
