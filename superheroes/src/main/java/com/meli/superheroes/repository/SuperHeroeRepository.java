package com.meli.superheroes.repository;

import com.meli.superheroes.model.SuperHeroe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SuperHeroeRepository extends JpaRepository<SuperHeroe,Long>{
    SuperHeroe findByNombre(String nombre);
    Optional<SuperHeroe> findById(Long id);

    List<SuperHeroe> findByNombreContainingIgnoreCase(String nombre);

}
