package com.galvanize.heroapp.service;

import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

//@ExtendWith(MockitoExtension.class)
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

        HeroService heroService = new HeroService(heroRepository);
        when(heroRepository.findAll()).thenReturn(
                Arrays.asList(new HeroResponse("Test"),
                                new HeroResponse("Test1"),
                                new HeroResponse("Test2")));
        List<HeroResponse> names = heroService.getAllHeroNames();

        assertEquals(3,names.size());
        assertEquals("Test", names.get(0).getName());
    }

}
