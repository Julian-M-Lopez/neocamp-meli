package com.meli.superheroes.adapter.out.persistence;

import com.meli.superheroes.domain.model.SuperHero;
import java.util.List;
import java.util.stream.Collectors;


public class SuperHeroMapper {

    public static SuperHero entityToDomain(SuperHeroEntity superHeroEntity) {
        // Mapea una entidad de persistencia a un objeto de dominio
        return SuperHero.builder()
                .id(superHeroEntity.getId())
                .name(superHeroEntity.getName())
                .description(superHeroEntity.getDescription())
                .capa(superHeroEntity.isCapa())
                .build();
    }

    public static SuperHeroEntity domainToEntity(SuperHero superHero) {
        // Mapea un objeto de dominio a una entidad de persistencia
        return SuperHeroEntity.builder()
                .id(superHero.getId())
                .name(superHero.getName())
                .description(superHero.getDescription())
                .capa(superHero.isCapa())
                .build();
    }

    public static List<SuperHero> entitiesToDomains(List<SuperHeroEntity> superHeroEntities) {
        // Mapea una lista de entidades de persistencia a una lista de objetos de dominio
        return superHeroEntities.stream()
                .map(SuperHeroMapper::entityToDomain)
                .collect(Collectors.toList());
    }

}
