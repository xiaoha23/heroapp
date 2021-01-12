package com.galvanize.heroapp.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HeroServiceTest {



    @Test
    void getAllHeroNames_returnsEmptyList(){
        HeroService heroService = new HeroService();
        List<String> names = heroService.getAllHeroNames();

        assertEquals(0,names.size());
    }
}
