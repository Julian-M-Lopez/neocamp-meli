package com.meli.superheroes.adapter.out.persistence;


import com.meli.superheroes.application.port.out.SuperHeroPortOut;
import com.meli.superheroes.domain.model.SuperHero;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuperHeroPersistenceAdapter implements SuperHeroPortOut {

    @Autowired
    private SuperHeroRepository superHeroRepository;

    @Autowired
    private SuperHeroMapper superHeroMapper;

    @Autowired
    public SuperHeroPersistenceAdapter(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    @Override
    public SuperHero saveSuperHero(SuperHero superHero) {
        SuperHeroEntity superHeroEntity = superHeroMapper.domainToEntity(superHero);
        superHeroRepository.save(superHeroEntity);
        return getSuperHeroById(superHeroEntity.getId());
    }

    @Override
    public void updateSuperHero(SuperHero superHero) {
        //  lógica de actualización en el repositorio
    }

    @Override
    public void deleteSuperHero(Long superHeroId) {
        // lógica de eliminación en el repositorio
    }

    @Override
    public SuperHero getSuperHeroById(Long superHeroId) {
        // lógica de obtención en el repositorio y retorna el resultado mapeado a la entidad de dominio
        SuperHeroEntity superHeroEntity = superHeroRepository.findById(superHeroId).orElse(null);
        return superHeroEntity != null ? SuperHeroMapper.entityToDomain(superHeroEntity) : null;
    }

    @Override
    public List<SuperHero> getSuperHeroesByName(String name) {
        // lógica de obtención en el repositorio y retorna los resultados mapeados a entidades de dominio
        List<SuperHeroEntity> superHeroEntities = superHeroRepository.findByName(name);
        return SuperHeroMapper.entitiesToDomains(superHeroEntities);
    }

    @Override
    public List<SuperHero> getAllSuperHeroes() {
        List<SuperHeroEntity> superHeroEntities = superHeroRepository.findAll();
        // Mapear las entidades a objetos de dominio y retornar la lista
        return SuperHeroMapper.entitiesToDomains(superHeroEntities);
    }

    @PostConstruct
    public void cargarSuperheroes() {
        // Cargar los datos de los superhéroes en la base de datos H2
        SuperHero superHero1 = SuperHero.builder()
                .id(null)
                .name("Superman")
                .description("Man of Steel")
                .capa(true)
                .build();
        SuperHero superHero2 = SuperHero.builder()
                .id(null)
                .name("Spiderman")
                .description("Friendly Neighborhood Spider-Man")
                .capa(false)
                .build();
        // Persistir los superhéroes en la base de datos
        superHeroRepository.save(SuperHeroMapper.domainToEntity(superHero1));
        superHeroRepository.save(SuperHeroMapper.domainToEntity(superHero2));
    }



}

