package com.meli.superheroes.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHeroEntity, Long> {
    List<SuperHeroEntity> findByName(String name);
}
