package com.galvanize.heroapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String realName;
    private String heroName;

    public Hero() {}

    public Hero(String realName, String heroName) {
        this.realName = realName;
        this.heroName = heroName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return Objects.equals(id, hero.id) && Objects.equals(realName, hero.realName) && Objects.equals(heroName, hero.heroName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, realName, heroName);
    }
}
