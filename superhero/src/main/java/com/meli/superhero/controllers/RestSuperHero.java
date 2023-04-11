package com.meli.superhero.controllers;

import com.meli.superhero.model.SuperHero;
import com.meli.superhero.services.ISuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/superhero")
public class RestSuperHero {


    private final ISuperHeroService iServiceSuperHero;

    @Autowired
    public RestSuperHero(final ISuperHeroService iServiceSuperHero) {
        this.iServiceSuperHero = iServiceSuperHero;
    }

    @PostMapping
    public ResponseEntity<SuperHero> addHero(@RequestBody SuperHero superHero){
        iServiceSuperHero.addHero(superHero);
        return new ResponseEntity<>(superHero, HttpStatus.CREATED);
    }

    @GetMapping("/{idHero}")
    public ResponseEntity<SuperHero> getHero(@PathVariable("idHero")int idHero ){
        Optional<SuperHero> hero = iServiceSuperHero.getHero(idHero);
        if(hero.isPresent())return ResponseEntity.ok(hero.get());
        return new ResponseEntity<>(null,HttpStatus.resolve(404));
    }

    @GetMapping("/all")
    public ResponseEntity<List<SuperHero>> getAllSuperHeros(){
        return ResponseEntity.ok(iServiceSuperHero.listHeros());
    }

    @DeleteMapping("/delete/{idHero}")
    public ResponseEntity<String> deleteHero(@PathVariable("idHero") int idHero){
        if(iServiceSuperHero.getHero(idHero).isPresent()){
            iServiceSuperHero.deleteHero(idHero);
            return  ResponseEntity.ok("Heroe eliminado");
        }else{
            return new ResponseEntity<>("No existe Heroe con la id : "+idHero,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<SuperHero>> searchHero(@RequestParam String heroName){
        return ResponseEntity.ok(iServiceSuperHero.contieneName(heroName));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateHero(@RequestBody SuperHero hero){
        if(iServiceSuperHero.getHero(hero.getIdSuperHero()).isPresent()){
            iServiceSuperHero.updateHero(hero);
            return ResponseEntity.ok("Heroe actualizado correctamente");
        }else return new ResponseEntity<>("No existe heroe con la id : "+hero.getIdSuperHero(),HttpStatus.NOT_FOUND);
    }
}
