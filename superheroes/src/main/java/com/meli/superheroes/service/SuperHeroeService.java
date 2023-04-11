package com.meli.superheroes.service;

import com.meli.superheroes.model.SuperHeroe;
import com.meli.superheroes.repository.SuperHeroeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperHeroeService {


    private SuperHeroeRepository superHeroeRepository;

    public SuperHeroeService(SuperHeroeRepository superHeroeRepository) {
        this.superHeroeRepository = superHeroeRepository;
    }

    // Métodos de servicio
    public List<SuperHeroe> getAllSuperHeroes() {
        return superHeroeRepository.findAll();
    }

    public SuperHeroe getSuperHeroeById(Long id) {
        return superHeroeRepository.findById(id).orElse(null);
    }

    public SuperHeroe getSuperHeroeByNombre(String nombre) {
        return superHeroeRepository.findByNombre(nombre);
    }

    public SuperHeroe saveSuperHeroe(SuperHeroe superHeroe) {
        return superHeroeRepository.save(superHeroe);
    }

    public void deleteSuperHeroe(Long id) {
        superHeroeRepository.deleteById(id);
    }

    @PostConstruct
    public void cargarSuperheroes() {
        // Cargar los datos de los superhéroes en la base de datos H2
        superHeroeRepository.save(new SuperHeroe(null, "Superman", "El último hijo de Krypton", true));
        superHeroeRepository.save(new SuperHeroe(null, "Batman", "El Caballero de la Noche", false));
        superHeroeRepository.save(new SuperHeroe(null, "Spiderman", "El Hombre Araña", false));
    }


    public List<SuperHeroe> buscarSuperHeroesPorNombre(String nombre) {
        // Puedes usar el método findByNombreContainingIgnoreCase() del repositorio
        // para buscar superhéroes por nombre que contengan el valor proporcionado,
        // ignorando mayúsculas y minúsculas.


        return superHeroeRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
