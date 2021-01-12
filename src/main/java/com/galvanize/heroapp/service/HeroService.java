package com.galvanize.heroapp.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService {

    private List<String> names;

    public HeroService(List<String> names) {
        this.names = names;
    }

    public List<String> getAllHeroNames() {

        return names;
    }
}
