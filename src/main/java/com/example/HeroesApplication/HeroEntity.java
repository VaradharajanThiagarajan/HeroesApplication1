package com.example.HeroesApplication;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@NoArgsConstructor

public class HeroEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   Long id;
   String name;
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

   public HeroEntity(String name)
   {
       this.name = name;
   }

   public Long getId() {
      return id;
   }

   public HeroEntity(String name, String image, int height, int weight, String specialPower, int strength, int power, int speed, int agility, String description, String story) {
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

   public String getName() {
      return name;
   }
}
