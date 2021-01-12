package com.galvanize.heroapp.controller;

import com.galvanize.heroapp.service.HeroService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class HeroControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HeroService heroService;

    @Test
    public void getAllHeroNames_returnListOfNames() throws Exception {
        when(heroService.getAllHeroNames())
                .thenReturn(asList("superMan"));
        mvc.perform(get("/hero"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllHeroNames_return204IfEmpty() throws Exception {
        mvc.perform(get("/hero"))
                .andExpect(status().isNoContent());
    }

}
