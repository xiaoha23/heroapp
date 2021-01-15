package com.galvanize.heroapp.service;

import com.galvanize.heroapp.entity.Hero;
import com.galvanize.heroapp.exception.APIEexception;
import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService implements HeroServiceInterface {

    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<HeroResponse> getAllHeroNames() {
        return heroRepository
                .findAll()
                .stream()
                .map(hero -> new HeroResponse(hero.getHeroName()))
                .collect(Collectors.toList());

    }

    @Override
    public Hero getHeroByName(String heroName) {
        Hero hero = heroRepository.findByHeroName(heroName);
        if (hero == null){
            throw new APIEexception("Hero doesn't exist");
        }
        return hero;
    }


}
