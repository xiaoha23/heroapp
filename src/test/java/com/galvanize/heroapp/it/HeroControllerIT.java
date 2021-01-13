package com.galvanize.heroapp.it;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.repository.HeroRepository;
import com.galvanize.heroapp.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
//@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class HeroControllerIT {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroRepository heroRepository;


    @Test
    void getAllHeroNames_return204IfEmpty() throws Exception {
        when(heroRepository.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/hero"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getAllHeroNames_returnListOfNames() throws Exception {

        List<HeroResponse> responseList = asList(new HeroResponse("test1"),
                new HeroResponse("test2"));
        when(heroRepository.findAll())
                .thenReturn(responseList);
        mockMvc.perform(get("/hero"))
                .andExpect(status().isOk())
                .andExpect(content().json(new ObjectMapper().writeValueAsString(responseList)));
    }

}
