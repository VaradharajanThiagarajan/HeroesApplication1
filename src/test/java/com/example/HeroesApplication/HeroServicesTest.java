package com.example.HeroesApplication;

import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class HeroServicesTest {

    @Mock
    HeroRepository mockHeroRepository;

    @InjectMocks
    HeroService subject;

    @Test
    void create() {
        HeroesDto heroesDto = new HeroesDto("superman");
        subject.create(heroesDto);
        verify(mockHeroRepository).save(
                new HeroEntity("superman")
        );
    }
}