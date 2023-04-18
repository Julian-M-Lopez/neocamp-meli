package com.neocamp.superhero.adapter.out.persistence;

import com.neocamp.superhero.domain.SuperHero;

public class SuperHeroMapper {
    public static SuperHero entityToDomain(SuperHeroEntity superHeroEntity) {
        return SuperHero.builder().id(superHeroEntity.getId())
                .city(superHeroEntity.getCity()).name(superHeroEntity.getName())
                .capa(superHeroEntity.isCapa())
                .description(superHeroEntity.getDescription()).build();
    }

    public static SuperHeroEntity domainToEntity(SuperHero superHero) {
        return SuperHeroEntity.builder().capa(superHero.isCapa())
                .id(superHero.getId()).description(superHero.getDescription())
                .city(superHero.getCity()).name(superHero.getName()).build();
    }

}
