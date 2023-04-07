package com.neocamp.superhero.repository;

import com.neocamp.superhero.model.SuperHero;
import jakarta.persistence.Id;
import org.springframework.data.repository.CrudRepository;

public interface IHeroRepository extends CrudRepository<SuperHero, Long> {


}
