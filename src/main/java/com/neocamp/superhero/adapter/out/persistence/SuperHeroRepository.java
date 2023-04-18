package com.neocamp.superhero.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SuperHeroRepository extends JpaRepository<SuperHeroEntity, Long> {

    Optional<SuperHeroEntity> findByName(String name);
}
