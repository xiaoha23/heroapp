package com.galvanize.heroapp.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class HeroRepository {

    public List<String> findAll(){
        return new ArrayList<>();
    }

}
