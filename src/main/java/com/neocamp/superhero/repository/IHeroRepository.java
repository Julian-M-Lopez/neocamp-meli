package com.neocamp.superhero.repository;

import com.neocamp.superhero.model.SuperHero;
import jakarta.persistence.Id;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IHeroRepository extends JpaRepository<SuperHero, Long> {

    List<SuperHero> findByName(String name);
}
