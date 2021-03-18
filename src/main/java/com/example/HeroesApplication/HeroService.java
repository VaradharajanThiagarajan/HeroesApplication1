package com.example.HeroesApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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


    public List<HeroesDto> fetchAll() {
        return heroRepository.findAll()
                .stream()
                .map(heroEntity -> {
                    return new HeroesDto(heroEntity.getName());
                })
                .collect(Collectors.toList());
    }


    public List<HeroesDto> findByname(String name) {
        return heroRepository.findByname(name)
                .stream()
                .map(heroEntity -> {
                    return new HeroesDto(heroEntity.getName());
                })
                .collect(Collectors.toList());
    }
}
