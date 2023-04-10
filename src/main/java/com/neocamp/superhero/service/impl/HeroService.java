package com.neocamp.superhero.service.impl;

import com.neocamp.superhero.model.SuperHero;
import com.neocamp.superhero.repository.IHeroRepository;
import com.neocamp.superhero.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeroService implements IHeroService {

    @Autowired
    private IHeroRepository repo;

    @Override
    public SuperHero addHero(SuperHero Hero) {
        return repo.save(Hero);
    }

    @Override
    public SuperHero updateHero(SuperHero Hero) {
        return repo.save(Hero);
    }

    @Override
    public List<SuperHero> listHeros() {
        return (List<SuperHero>) repo.findAll();
    }

    @Override
    public Optional<SuperHero> getHero(Long idHero) {
        return repo.findById(idHero);
    }

    @Override
    public void deleteHero(Long idHero) {
        repo.deleteById(idHero);
    }
}
