package com.neocamp.superhero.adapter.in.controller;

import com.neocamp.superhero.application.port.in.SuperHeroPortIn;
import com.neocamp.superhero.common.common.WebAdapter;
import com.neocamp.superhero.domain.SuperHero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RestController
@RequestMapping("/superhero")
public class SuperHeroController {

    private final SuperHeroPortIn superHeroPortIn;

    public SuperHeroController(SuperHeroPortIn superHeroPortIn) {
        this.superHeroPortIn = superHeroPortIn;
    }

    @PostMapping("/add")
    public ResponseEntity<SuperHero> addHero(@RequestBody SuperHero superHero){
        superHero.setName(superHero.getName().toLowerCase());
        return new ResponseEntity<>(superHeroPortIn.addSuperHero(superHero),HttpStatus.CREATED);
    }

    @GetMapping("/{idHero}")
    public ResponseEntity<SuperHero>getHero(@PathVariable("idHero") Long idSuperHero){
        return new ResponseEntity<>(superHeroPortIn.getSuperHero(idSuperHero),HttpStatus.OK);
    }


    @GetMapping(value = "/name/{nameHero}")
    public ResponseEntity<SuperHero>getNameHero(@PathVariable("nameHero") String name){
        return new ResponseEntity<>(superHeroPortIn.getSuperHeroForName(name),HttpStatus.OK);
    }
//
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<List<SuperHero>> getAllHero (){
        return new ResponseEntity<>(superHeroPortIn.getAllSuperHero(),HttpStatus.OK);
    }
//
    @DeleteMapping("/delete/{idHero}")
    public ResponseEntity<SuperHero> deleteHero(@PathVariable("idHero") Long idSuperHero){
        superHeroPortIn.deleteSuperHero(idSuperHero);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{idHero}")
    public ResponseEntity<SuperHero> updateHero(@RequestBody SuperHero superHero, @PathVariable("idHero") Long idSuperHero){

        return new ResponseEntity<>(superHeroPortIn.editSuperHero(superHero,idSuperHero),HttpStatus.OK);
    }

}
