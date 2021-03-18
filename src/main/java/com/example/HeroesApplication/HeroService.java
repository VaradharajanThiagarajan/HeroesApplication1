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
        //heroRepository.save(new HeroEntity(heroDto.getName()));
        heroRepository.save(new HeroEntity(heroDto.getName(),heroDto.getImage(), heroDto.getHeight(), heroDto.getWeight(), heroDto.getSpecialPower(), heroDto.getStrength(), heroDto.getPower(), heroDto.getSpeed(), heroDto.getAgility(), heroDto.getDescription(), heroDto.getStory()));
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
                    return new HeroesDto(heroEntity.getName(), heroEntity.getImage(), heroEntity.getHeight(), heroEntity.getWeight(), heroEntity.getSpecialPower(), heroEntity.getStrength(), heroEntity.getPower(), heroEntity.getSpeed(), heroEntity.getAgility(), heroEntity.getDescription(), heroEntity.getStory());
                })
                .collect(Collectors.toList());
    }
}
