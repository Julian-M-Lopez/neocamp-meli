package com.neocamp.superhero.controller;

import com.neocamp.superhero.exception.FieldHeroEmptyException;
import com.neocamp.superhero.exception.ModelNotFoundException;
import com.neocamp.superhero.model.SuperHero;
import com.neocamp.superhero.repository.IHeroRepository;
import com.neocamp.superhero.service.IHeroService;
import com.neocamp.superhero.service.impl.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/superhero")
public class HeroController {

    @Autowired
     private IHeroService iservice;


    @PostMapping("/add")
    public ResponseEntity<SuperHero> addHero(@RequestBody SuperHero hero){
        return  ResponseEntity.ok(iservice.addHero(hero));
    }

    @GetMapping("/{idHero}")
    public ResponseEntity<SuperHero>getHero(@PathVariable("idHero") Long idHero){
        Optional<SuperHero> hero = iservice.getHero(idHero);
        if(hero.isEmpty() ){
            throw new ModelNotFoundException("el heroe no fue encontrado");
        }
        return ResponseEntity.ok(hero.get());

    }
    @GetMapping("/name/{name}")
    public ResponseEntity<List<SuperHero>>getNameHero(@PathVariable("name") String name){

        if(name.isBlank()){
            throw new FieldHeroEmptyException("campo nombre heroe vacio");
        }
        return ResponseEntity.ok(iservice.getNameHero(name));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SuperHero>> getAllHero (){
        List<SuperHero> hero =iservice.listHeros();
        if(hero.isEmpty()){
            throw new ModelNotFoundException("no se encuentra ningun hero registrado");
        }
        return ResponseEntity.ok(hero);
    }

    @DeleteMapping("/delete/{idHero}")
    public ResponseEntity<Object> deleteHero(@PathVariable("idHero") Long idHero){
        Optional<SuperHero> hero = iservice.getHero(idHero);
        if(hero.isEmpty() ){
            throw new ModelNotFoundException("el id no fue encontrado");
        }
        iservice.deleteHero(idHero);
        return  ResponseEntity.ok(Boolean.TRUE);
    }

    @PutMapping("/update/{idHero}")
    public ResponseEntity<Object> updateHero(@RequestBody SuperHero hero,@PathVariable("idHero") Long idHero){
        iservice.updateHero(hero,idHero);
        return ResponseEntity.ok(Boolean.TRUE);
    }

}
