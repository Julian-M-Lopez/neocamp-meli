package com.neocamp.superhero.application.service;

import com.neocamp.superhero.application.port.in.SuperHeroPortIn;
import com.neocamp.superhero.application.port.out.SuperHeroPortOut;
import com.neocamp.superhero.common.common.UseCase;
import com.neocamp.superhero.common.exception.ModelNotFoundException;
import com.neocamp.superhero.domain.SuperHero;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public SuperHero getSuperHero(Long idSuperHero) {
        Optional<SuperHero> superHero = superHeroPortOut.getSuperHero(idSuperHero);
        if (superHero.isEmpty()){
            throw new ModelNotFoundException("No se a encontrado el supuer heroe");
        }
        return superHero.get() ;
    }

    @Override
    public SuperHero getSuperHeroForName(String name) {
        Optional<SuperHero> superHero = superHeroPortOut.getSuperHeroForName(name);
        if(superHero.isEmpty()){
            throw new ModelNotFoundException("no se a encontrado un heroe con este nombre");
        }
        return superHero.get();
    }

    @Override
    public List<SuperHero> getAllSuperHero() {
        List<SuperHero> superHeroes = superHeroPortOut.getAllSuperHero();
        if (superHeroes.isEmpty()){
            throw new ModelNotFoundException("No hay heroes resgistrados");
        }

        return superHeroes;
    }

    @Override
    public void deleteSuperHero(Long idSuperHero) {
        this.getSuperHero(idSuperHero);
        superHeroPortOut.deleteSuperhero(idSuperHero);
    }

    @Override
    public SuperHero editSuperHero(SuperHero superHero, Long idSuperHero) {
        SuperHero heroe = this.getSuperHero(idSuperHero);
        heroe.setName(superHero.getName());
        heroe.setDescription(superHero.getDescription());
        heroe.setCapa(superHero.isCapa());
        heroe.setCity(superHero.getCity());
        return this.addSuperHero(heroe);
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
