package com.example.HeroesApplication;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

 import java.util.List;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long> {

 public List<HeroEntity> findByname(String name);
}
