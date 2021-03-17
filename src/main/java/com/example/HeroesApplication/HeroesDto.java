package com.example.HeroesApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class HeroesDto {

    private String name;

    public String getName() {
        return name;
    }
}
