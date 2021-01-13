package com.galvanize.heroapp.service;

import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {

    private List<String> names;

    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public List<HeroResponse> getAllHeroNames() {

        return heroRepository
                .findAll()
                .stream()
                .map(hero -> new HeroResponse(hero.getHeroName()))
                .collect(Collectors.toList());
    }
}
