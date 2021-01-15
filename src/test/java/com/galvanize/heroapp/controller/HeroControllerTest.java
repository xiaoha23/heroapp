package com.galvanize.heroapp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.heroapp.entity.Hero;
import com.galvanize.heroapp.exception.APIEexception;
import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.service.HeroService;
import com.galvanize.heroapp.service.HeroServiceInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;

import static java.util.Arrays.asList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class HeroControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private HeroServiceInterface heroServiceInterface;

    @Test
    public void getAllHeroNames_returnListOfNames() throws Exception {
        when(heroServiceInterface.getAllHeroNames())
                .thenReturn(asList(new HeroResponse("superMan")));
        mvc.perform(get("/hero"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("superMan"));
    }

    @Test
    public void getAllHeroNames_return204IfEmpty() throws Exception {
        mvc.perform(get("/hero"))
                .andExpect(status().isNoContent());
    }

    @Test
    void getHeroByName_returnHeroDetail() throws Exception {

        Hero spiderMan = new Hero("Mike Smith", "spiderman");

        when(heroServiceInterface.getHeroByName(anyString())).thenReturn(spiderMan);
        mvc.perform(get("/hero/spiderman"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(spiderMan)));
    }

    @Test
    void getHeroByName_returnNoHeroDetail() throws Exception {

        APIEexception exp = new APIEexception("Hero doesn't exist");
        doThrow(exp).when(heroServiceInterface).getHeroByName(anyString());
        mvc.perform(get("/hero/spiderman"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").value("Hero doesn't exist"));
    }
}
