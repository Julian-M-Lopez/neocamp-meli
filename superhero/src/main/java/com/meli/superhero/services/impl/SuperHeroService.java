package com.meli.superhero.services.impl;

import com.meli.superhero.model.SuperHero;
import com.meli.superhero.repository.SuperHeroRepository;
import com.meli.superhero.services.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroService implements ISuperHeroService {

    @Autowired
    private SuperHeroRepository superHeroRepository;

    @Override
    public SuperHero addHero(SuperHero superHero) {
        return superHeroRepository.save(superHero);
    }

    @Override
    public SuperHero updateHero(SuperHero superHero) {
        return superHeroRepository.save(superHero);
    }

    @Override
    public List<SuperHero> listHeros() {
        return superHeroRepository.findAll();
    }

    @Override
    public Optional<SuperHero> getHero(int idHero) {
        return superHeroRepository.findById(idHero);
    }

    @Override
    public void deleteHero(int idHero) {
        superHeroRepository.deleteById(idHero);
    }
}
