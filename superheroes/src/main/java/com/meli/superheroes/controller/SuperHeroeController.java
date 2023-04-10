package com.meli.superheroes.controller;

import com.meli.superheroes.model.SuperHeroe;
import com.meli.superheroes.service.SuperHeroeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
@AllArgsConstructor
public class SuperHeroeController {

    private final SuperHeroeService superHeroeService;

    @GetMapping
    public List<SuperHeroe> obtenerSuperHeroes() {

        return superHeroeService.obtenerSuperHeroes();
    }

    @GetMapping("/{nombre}")
    public String obtenerSuperHeroe(@PathVariable String nombre) {
        SuperHeroe superHeroe = superHeroeService.obtenerSuperHeroePorNombre(nombre);
        if (superHeroe != null) {
            return "El superhéroe " + superHeroe.getNombre() + " es " + superHeroe.getDescripcion();
        } else {
            return "No se encontró el superhéroe " + nombre;
        }
    }
}
