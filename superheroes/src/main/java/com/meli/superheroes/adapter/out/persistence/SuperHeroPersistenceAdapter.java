package com.meli.superheroes.adapter.out.persistence;


import com.meli.superheroes.application.port.out.SuperHeroPortOut;
import com.meli.superheroes.common.common.PersistenceAdapter;
import com.meli.superheroes.domain.model.SuperHero;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@PersistenceAdapter
public class SuperHeroPersistenceAdapter implements SuperHeroPortOut {

    private final SuperHeroRepository superHeroRepository;


    @Autowired
    public SuperHeroPersistenceAdapter(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }

    @Override
    public SuperHero saveSuperHero(SuperHero superHero) {
        SuperHeroEntity superHeroEntity = SuperHeroMapper.domainToEntity(superHero);
        superHeroRepository.save(superHeroEntity);
        return getSuperHeroById(superHeroEntity.getId());
    }

    @Override
    public SuperHero updateSuperHero(Long id, SuperHero superHeroeActualizado) {
        // lógica de actualización en el repositorio

        SuperHeroEntity superHeroeExistente = superHeroRepository.findById(id).orElse(null);

        if (superHeroeExistente != null && superHeroeActualizado != null) {
            if (superHeroeActualizado.getName() != null) {
                superHeroeExistente.setName(superHeroeActualizado.getName());
            }
            if (superHeroeActualizado.getDescription() != null) {
                superHeroeExistente.setDescription(superHeroeActualizado.getDescription());
            }

            if (superHeroeActualizado.isCapa()!= superHeroeExistente.isCapa()) {
                superHeroeExistente.setCapa(superHeroeActualizado.isCapa());
            }

            // Guardar el superhéroe actualizado en el repositorio
            superHeroeExistente = superHeroRepository.save(superHeroeExistente);
        }

        // Devolver el superhéroe existente (actualizado) en la respuesta
        return SuperHeroMapper.entityToDomain(superHeroeExistente);
    }


    @Override
    public void deleteSuperHero(Long superHeroId) {
        // lógica de eliminación en el repositorio
        SuperHeroEntity superHeroEntity = superHeroRepository.findById(superHeroId).orElse(null);
        if (superHeroEntity != null) {
            superHeroRepository.deleteById(superHeroId);
        }
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
        List<SuperHeroEntity> superHeroEntities = superHeroRepository.findByNameContainingIgnoreCase(name);
        return SuperHeroMapper.entitiesToDomains(superHeroEntities);
    }

    @Override
    public List<SuperHero> getAllSuperHeroes() {
        List<SuperHeroEntity> superHeroEntities = superHeroRepository.findAll();
        // Mapear las entidades a objetos de dominio y retornar la lista
        return SuperHeroMapper.entitiesToDomains(superHeroEntities);
    }
}

