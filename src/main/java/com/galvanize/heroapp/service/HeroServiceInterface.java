package com.galvanize.heroapp.service;

import com.galvanize.heroapp.entity.Hero;
import com.galvanize.heroapp.model.HeroResponse;

import java.util.List;

public interface HeroServiceInterface {

    List<HeroResponse> getAllHeroNames();

    Hero getHeroByName(String heroName);
}
