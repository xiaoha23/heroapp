package com.galvanize.heroapp.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.heroapp.entity.Hero;
import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.repository.HeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class HeroControllerIT {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HeroRepository heroRepository;

    @BeforeEach
    public void setup() {
        heroRepository.deleteAll();
    }


    @Test
    void getAllHeroNames_return204IfEmpty() throws Exception {
        mockMvc.perform(get("/hero"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getAllHeroNames_returnListOfNames() throws Exception {
        Hero hero1 = new Hero("real name", "test1");
        Hero hero2 = new Hero("real name 1", "test2");

        heroRepository.saveAll(asList(hero1, hero2));

        List<HeroResponse> responseList = asList(new HeroResponse("test1"),
                new HeroResponse("test2"));
        mockMvc.perform(get("/hero"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(responseList)));
    }

    @Test
    public void getHeroByName_returnHeroDetail() throws Exception {
        Hero hero1 = new Hero("real name", "test1");

        heroRepository.save(hero1);

        mockMvc.perform(get("/hero/test1"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(hero1)));
    }

    @Test
    public void getHeroByName_throwException_whenNotFound() throws Exception {
        mockMvc.perform(get("/hero/test1"))
                .andExpect(status().isNotFound());
    }

}
