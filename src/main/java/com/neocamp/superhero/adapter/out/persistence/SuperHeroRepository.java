package com.neocamp.superhero.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuperHeroRepository extends JpaRepository<SuperHeroEntity, Long> {

    List<SuperHeroEntity> findByName(String name);
}
