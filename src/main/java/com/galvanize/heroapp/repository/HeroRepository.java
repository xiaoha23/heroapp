package com.galvanize.heroapp.repository;

import com.galvanize.heroapp.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {

    Hero findByHeroName(String heroName);
}
