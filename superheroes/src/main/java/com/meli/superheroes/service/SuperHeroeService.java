package com.meli.superheroes.service;

import com.meli.superheroes.model.SuperHeroe;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SuperHeroeService {
    List<SuperHeroe> superHeroes = new ArrayList<>();
    public SuperHeroeService() {
        superHeroes.add(new SuperHeroe("Superman", "El último hijo de Krypton"));
        superHeroes.add(new SuperHeroe("Batman", "El caballero de la noche"));
        superHeroes.add(new SuperHeroe("Spiderman", "El trepamuros"));
    }


    public List<SuperHeroe> obtenerSuperHeroes() {
        return superHeroes;
    }

    public SuperHeroe obtenerSuperHeroePorNombre(String nombre) {
        for (SuperHeroe superHeroe : superHeroes) {
            if (superHeroe.getNombre().equalsIgnoreCase(nombre)) {
                return superHeroe;
            }
        }
        return null;
    }
}
