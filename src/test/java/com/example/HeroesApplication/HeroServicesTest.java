package com.example.HeroesApplication;

import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

    @Test
    void fetchAll() {

        // S Seat
        HeroEntity heroEntity1 = new HeroEntity("zeman");
        HeroEntity heroEntity2 = new HeroEntity("suman");
        List<HeroEntity> listveri = new ArrayList<HeroEntity>();

        HeroesDto heroDto1 = new HeroesDto("zeman");
        HeroesDto heroDto2 = new HeroesDto("suman");

        List<HeroesDto> listveri2 = new ArrayList<HeroesDto>();

        listveri.add(heroEntity1);
        listveri.add(heroEntity2);

        listveri2.add(heroDto1);
        listveri2.add(heroDto2);


        when(mockHeroRepository.findAll()).thenReturn(listveri);

        // E Exercise
        List<HeroesDto> actual = subject.fetchAll();

        // A Assert
        assertThat(actual).isEqualTo(listveri2);



    }
}