package com.galvanize.heroapp.controller;

import com.galvanize.heroapp.model.HeroResponse;
import com.galvanize.heroapp.service.HeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@RestController
public class HeroController {


    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/hero")
    public ResponseEntity<List<HeroResponse>> getAllHeroNames() {
        List<HeroResponse> names = heroService.getAllHeroNames();
        return isEmpty(names) ?
                new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(names, HttpStatus.OK);
    }
}
