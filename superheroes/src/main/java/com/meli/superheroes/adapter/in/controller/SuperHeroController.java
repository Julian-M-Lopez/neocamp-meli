package com.meli.superheroes.adapter.in.controller;

import com.meli.superheroes.application.port.in.SuperHeroPortIn;
import com.meli.superheroes.domain.model.SuperHero;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
@AllArgsConstructor
public class SuperHeroController {
    private final SuperHeroPortIn superHeroPortIn;

    @GetMapping("/{id:\\d+}")
    public ResponseEntity<SuperHero> getHeroById(@PathVariable Long id) {
        SuperHero superHero = superHeroPortIn.getSuperHeroById(id);
        if (superHero != null) {
            return ResponseEntity.ok(superHero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<List<SuperHero>> getAllHeroes() {
        return new ResponseEntity<>(superHeroPortIn.getAllSuperHeroes(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SuperHero> addHero(@RequestBody SuperHero superHero){
        superHero.setName(superHero.getName().toLowerCase());
        return new ResponseEntity<>(superHeroPortIn.addSuperHero(superHero), HttpStatus.CREATED);
    }
}
