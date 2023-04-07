package com.neocamp.superhero.controller;

import com.neocamp.superhero.model.SuperHero;
import com.neocamp.superhero.repository.IHeroRepository;
import com.neocamp.superhero.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/superhero")
public class HeroController {

    @Autowired
     private IHeroService iservice;


    @GetMapping("/")
    public ResponseEntity<SuperHero> addHero(@RequestBody SuperHero hero){
        return new ResponseEntity<>(hero, HttpStatus.CREATED);
    }

    @GetMapping("/{idHero}")
    public ResponseEntity<SuperHero>getHero(@PathVariable("idHero") Long idHero){
        Optional<SuperHero> hero = iservice.getHero(idHero);
        return ResponseEntity.ok(hero.get());
    }

}
