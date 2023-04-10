package com.meli.superheroes.repository;

import com.meli.superheroes.model.SuperHeroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroe,String>{



}
