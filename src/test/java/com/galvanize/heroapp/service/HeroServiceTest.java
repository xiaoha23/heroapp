package com.galvanize.heroapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroServiceTest {



    @Test
    void getAllHeroNames_returnsEmptyList(){
        HeroService heroService = new HeroService(new ArrayList<>());
        List<String> names = heroService.getAllHeroNames();

        assertEquals(0,names.size());
    }

    @Test
    void getAllHeroNames_returnsListOfAllNames(){

        HeroService heroService = new HeroService(Arrays.asList("superman","spiderman","bond"));
        List<String> names = heroService.getAllHeroNames();

        assertEquals(3,names.size());
    }

}
