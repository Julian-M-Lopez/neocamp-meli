package com.neocamp.superhero.application.port.out;

import com.neocamp.superhero.domain.SuperHero;

public interface SuperHeroPortOut {
    public SuperHero persistSuperHero(SuperHero superHero);

}
