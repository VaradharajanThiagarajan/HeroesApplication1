package com.example.HeroesApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc


public class HeroApplicationIT {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void addHeroes() throws Exception {


        HeroesDto hero1 = new HeroesDto("zuperman");
        HeroesDto hero2 = new HeroesDto("heman");

        mockMvc.perform(post("/heroes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hero1))
        ).andExpect(status().isCreated());

        mockMvc.perform(post("/heroes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hero2))
        ).andExpect(status().isCreated());

       //assertion to ensure value post above is retrieved successfully
        mockMvc.perform(get("/heroes")).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(2))
                .andExpect(jsonPath("[0].name").value("zuperman"))
                .andExpect(jsonPath("[1].name").value("heman"));


    }

    @Test
    public void fetchHeroesbyName() throws Exception {


        HeroesDto hero1 = new HeroesDto("zuperman");
        HeroesDto hero2 = new HeroesDto("zeman","image1",100,100,"fire",100,200,100,100,"description123","story123");

        mockMvc.perform(post("/heroes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hero1))
        ).andExpect(status().isCreated());

        mockMvc.perform(post("/heroes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hero2))
        ).andExpect(status().isCreated());

        //assertion to ensure value post above is retrieved successfully
        mockMvc.perform(get("/heroesByName/")
                .param("name","zeman")

        ).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("zeman"))
                .andExpect(jsonPath("[0].image").value("image1"))
                .andExpect(jsonPath("[0].height").value(100))
                .andExpect(jsonPath("[0].weight").value(100))
                .andExpect(jsonPath("[0].specialPower").value("fire"))
                //.andExpect(jsonPath("[0].intelligence").value(100))
                .andExpect(jsonPath("[0].strength").value(100))
                .andExpect(jsonPath("[0].power").value(200))
                .andExpect(jsonPath("[0].speed").value(100))
                .andExpect(jsonPath("[0].agility").value(100))
                .andExpect(jsonPath("[0].description").value("description123"))
                .andExpect(jsonPath("[0].story").value("story123"));


    }
}
