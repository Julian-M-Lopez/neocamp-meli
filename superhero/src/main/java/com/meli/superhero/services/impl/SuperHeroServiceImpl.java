package com.meli.superhero.services.impl;

import com.meli.superhero.model.SuperHero;
import com.meli.superhero.repository.SuperHeroRepository;
import com.meli.superhero.services.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuperHeroServiceImpl implements ISuperHeroService {

    private final SuperHeroRepository superHeroRepository;

    @Autowired
    public SuperHeroServiceImpl(final SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

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

    @Override
    public List<SuperHero> contieneName(String name) {
        return (List<SuperHero>) listHeros().stream().filter(hero -> hero.getNombre().contains(name));
    }
}
