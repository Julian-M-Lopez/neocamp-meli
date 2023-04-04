package com.meli.superhero.controllers;

import com.meli.superhero.model.SuperHero;
import com.meli.superhero.services.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/superhero")
public class RestSuperHero {

    @Autowired
    private ISuperHeroService iServiceSuperHero;

    @PostMapping("/")
    public ResponseEntity<SuperHero> addHero(@RequestBody SuperHero superHero){
        //return ResponseEntity.ok(iServiceSuperHero.addHero(superHero));
        return new ResponseEntity<>(superHero, HttpStatus.CREATED);
    }

    @GetMapping("/{idHero}")
    public ResponseEntity<SuperHero> getHero(@PathVariable("idHero")int idHero ){
        Optional<SuperHero> hero = iServiceSuperHero.getHero(idHero);
        if(hero.isPresent())return ResponseEntity.ok(hero.get());
        return new ResponseEntity<>(null,HttpStatus.resolve(404));
    }
}
