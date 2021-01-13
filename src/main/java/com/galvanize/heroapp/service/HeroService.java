package com.galvanize.heroapp.service;

import com.galvanize.heroapp.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {

    private List<String> names;

    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

//    public HeroService() {
//    }
//
//    public HeroService(List<String> names) {
//        this.names = names;
//    }

    public List<String> getAllHeroNames() {
        return heroRepository.findAll();
    }
}
