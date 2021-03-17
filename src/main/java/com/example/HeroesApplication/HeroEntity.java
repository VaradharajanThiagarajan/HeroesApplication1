package com.example.HeroesApplication;

import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode

public class HeroEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   Long id;
   String name;
   public HeroEntity(String name)
   {
       this.name = name;
   }
}
