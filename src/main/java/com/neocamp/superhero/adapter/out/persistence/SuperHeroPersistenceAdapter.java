package com.neocamp.superhero.adapter.out.persistence;

import com.neocamp.superhero.application.port.out.SuperHeroPortOut;
import com.neocamp.superhero.common.common.PersistenceAdapter;
import com.neocamp.superhero.domain.SuperHero;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@PersistenceAdapter
public class SuperHeroPersistenceAdapter implements SuperHeroPortOut {

    private final SuperHeroRepository superHeroRepository;

    public SuperHeroPersistenceAdapter(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    @Override
    public SuperHero persistSuperHero(SuperHero superHero) {
        return SuperHeroMapper.entityToDomain(superHeroRepository
                .save(SuperHeroMapper.domainToEntity(superHero)));
    }

    @Override
    public Optional<SuperHero> getSuperHero(Long idSuperHero) {
        Optional<SuperHeroEntity> superHero = superHeroRepository.findById(idSuperHero);
        if (superHero.isPresent()){
            return Optional.of(SuperHeroMapper.entityToDomain(superHero.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<SuperHero> getSuperHeroForName(String name) {
       Optional<SuperHeroEntity> superHero = superHeroRepository.findByName(name);
       if(superHero.isPresent()){
           return Optional.of(SuperHeroMapper.entityToDomain(superHero.get()));
       }
       return Optional.empty();
    }

    @Override
    public List<SuperHero> getAllSuperHero() {
        List<SuperHeroEntity> superHero =superHeroRepository.findAll();
        return superHero.stream()
                .map(hero -> SuperHeroMapper.entityToDomain(hero)).collect(Collectors.toList());
    }

    @Override
    public void deleteSuperhero(Long idSuperHero) {
        Optional<SuperHeroEntity> superHero = superHeroRepository.findById(idSuperHero);
        superHeroRepository.delete(superHero.get());
    }


}
