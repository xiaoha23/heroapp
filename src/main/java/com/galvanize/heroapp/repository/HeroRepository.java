package com.galvanize.heroapp.repository;

import com.galvanize.heroapp.model.HeroResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class HeroRepository {

    public List<HeroResponse> findAll(){
        return new ArrayList<>();
    }

}
