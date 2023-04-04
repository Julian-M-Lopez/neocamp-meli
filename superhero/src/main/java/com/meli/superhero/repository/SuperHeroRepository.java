package com.meli.superhero.repository;

import com.meli.superhero.model.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroRepository extends JpaRepository<SuperHero, Integer> {
}
