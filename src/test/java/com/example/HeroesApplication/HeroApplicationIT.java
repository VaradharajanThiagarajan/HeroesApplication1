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

        mockMvc.perform(post("/heroes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(hero1))
        ).andExpect(status().isCreated());
       //assertion to ensure value post above is retrieved successfully
        mockMvc.perform(get("/heroes")).andExpect(status().isOk())
                .andExpect(jsonPath("length()").value(1))
                .andExpect(jsonPath("[0].name").value("zuperman"));




    }
}
