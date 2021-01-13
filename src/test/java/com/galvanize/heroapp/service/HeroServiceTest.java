package com.galvanize.heroapp.service;

import com.galvanize.heroapp.entity.Hero;
import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class HeroServiceTest {

    @Mock
    private HeroRepository heroRepository;

    @BeforeEach
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllHeroNames_returnsEmptyList(){
        HeroService heroService = new HeroService(heroRepository);

        when(heroRepository.findAll()).thenReturn(new ArrayList<>());
        List<HeroResponse> names = heroService.getAllHeroNames();

        assertEquals(0,names.size());
    }

    @Test
    void getAllHeroNames_returnsListOfAllNames(){

        Hero hero1 = new Hero("real name", "Test");
        Hero hero2 = new Hero("real name 1", "Test1");
        Hero hero3 = new Hero("real name 2", "Test2");

        HeroService heroService = new HeroService(heroRepository);
        when(heroRepository.findAll()).thenReturn(
                Arrays.asList(hero1, hero2, hero3));
        List<HeroResponse> names = heroService.getAllHeroNames();

        assertEquals(3,names.size());
        assertEquals("Test", names.get(0).getName());
    }

}
