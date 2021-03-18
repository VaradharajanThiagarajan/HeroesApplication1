package com.example.HeroesApplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class HeroesDto {

    private String name;
    private String image;
    private int height;
    private int weight;
    private String specialPower;
    private int strength;
    private int power;
    private int speed;
    private int agility;
    private String description;
    private String story;

    public HeroesDto(String name, String image, int height, int weight, String specialPower, int strength, int power, int speed, int agility, String description, String story) {
        this.name = name;
        this.image = image;
        this.height = height;
        this.weight = weight;
        this.specialPower = specialPower;
        this.strength = strength;
        this.power = power;
        this.speed = speed;
        this.agility = agility;
        this.description = description;
        this.story = story;
    }

    public String getImage() {
        return image;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public int getStrength() {
        return strength;
    }

    public int getPower() {
        return power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getAgility() {
        return agility;
    }

    public String getDescription() {
        return description;
    }

    public String getStory() {
        return story;
    }

    public HeroesDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
