package com.galvanize.heroapp.service;

import com.galvanize.heroapp.entity.Hero;
import com.galvanize.heroapp.exception.APIEexception;
import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
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

    @Test
    void getHeroByName_returnHeroDetail() {
        Hero hero1 = new Hero("real name", "Test1");

        HeroService heroService = new HeroService(heroRepository);
        when(heroRepository.findByHeroName(anyString())).thenReturn(hero1);

        Hero expected = heroService.getHeroByName(anyString());

        assertThat(expected).isEqualTo(hero1);
    }

    @Test
    void getHeroByName_throwException_whenNotFound() {
        HeroService heroService = new HeroService(heroRepository);
        when(heroRepository.findByHeroName(anyString())).thenReturn(null);

        APIEexception apiEexception =
            assertThrows(APIEexception.class, () -> heroService.getHeroByName("not found"));
        assertEquals("Hero doesn't exist", apiEexception.getErroMsg());
    }

}
