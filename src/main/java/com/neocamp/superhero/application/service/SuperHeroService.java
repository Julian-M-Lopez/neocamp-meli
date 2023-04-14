package com.neocamp.superhero.application.service;

import com.neocamp.superhero.application.port.in.SuperHeroPortIn;
import com.neocamp.superhero.application.port.out.SuperHeroPortOut;
import com.neocamp.superhero.common.common.UseCase;
import com.neocamp.superhero.domain.SuperHero;
import org.springframework.stereotype.Service;

@UseCase
public class SuperHeroService implements SuperHeroPortIn {

    private final SuperHeroPortOut superHeroPortOut;

    public SuperHeroService(SuperHeroPortOut superHeroPortOut) {
        this.superHeroPortOut = superHeroPortOut;
    }

    @Override
    public SuperHero addSuperHero(SuperHero superHero) {
        return superHeroPortOut.persistSuperHero(superHero);
    }

//    @Override
//    public SuperHeroEntity addHero(SuperHeroEntity Hero) {
//        return repo.save(Hero);
//    }
//
//    @Override
//    public SuperHeroEntity updateHero(SuperHeroEntity Hero, Long idHero) {
//        Optional<SuperHeroEntity> heros = repo.findById(idHero);
//        SuperHeroEntity heroe = heros.get();
//        heroe.setName(Hero.getName());
//        heroe.setDescription(Hero.getDescription());
//        heroe.setCapa(Hero.isCapa());
//        heroe.setCity(Hero.getCity());
//
//        return repo.save(heroe);
//    }
//    @Override
//    public List<SuperHeroEntity> listHeros() {
//        return (List<SuperHeroEntity>) repo.findAll();
//    }
//
//
//
//    @Override
//    public Optional<SuperHeroEntity> getHero(Long idHero) {
//        return repo.findById(idHero);
//    }
//
//    @Override
//    public List<SuperHeroEntity> getNameHero(String name) {
//        return repo.findByName(name);
//    }
//
//    @Override
//    public void deleteHero(Long idHero) {
//        repo.deleteById(idHero);
//    }
}
