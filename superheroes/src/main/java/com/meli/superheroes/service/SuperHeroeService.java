package com.meli.superheroes.service;

import com.meli.superheroes.model.SuperHeroe;
import lombok.Getter;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SuperHeroeService {
    List<SuperHeroe> superHeroes = new ArrayList<>();
    public SuperHeroeService() {
        superHeroes.add(new SuperHeroe("Superman", "El último hijo de Krypton", true));
        superHeroes.add(new SuperHeroe("Batman", "El caballero de la noche", true));
        superHeroes.add(new SuperHeroe("Spiderman", "El trepamuros", false));
    }
    public List<SuperHeroe> obtenerSuperHeroes() {
        return superHeroes;
    }

    public SuperHeroe obtenerSuperHeroePorNombre(String nombre) {
        return superHeroes.stream()
                .filter(superHeroe -> superHeroe.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
