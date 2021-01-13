package com.galvanize.heroapp.it;

import com.galvanize.heroapp.service.HeroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@AutoConfigureWebMvc
@AutoConfigureMockMvc
public class HeroControllerIT {


    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllHeroNames_return204IfEmpty() throws Exception {

        mockMvc.perform(get("/hero"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void getAllHeroNames_returnListOfNames() throws Exception {

        mockMvc.perform(get("/hero"))
                .andExpect(status().isOk());
    }

}
