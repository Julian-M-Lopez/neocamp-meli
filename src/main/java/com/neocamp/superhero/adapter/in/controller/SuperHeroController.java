package com.neocamp.superhero.adapter.in.controller;

import com.neocamp.superhero.application.port.in.SuperHeroPortIn;
import com.neocamp.superhero.common.common.WebAdapter;
import com.neocamp.superhero.domain.SuperHero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/add")
//    public ResponseEntity<SuperHeroEntity> addHero(@RequestBody SuperHeroEntity hero){
//        hero.setName(hero.getName().toLowerCase());
//        return new ResponseEntity<>(iservice.addHero(hero),HttpStatus.CREATED);
//    }

//    @GetMapping("/{idHero}")
//    public ResponseEntity<SuperHeroEntity>getHero(@PathVariable("idHero") Long idHero){
//        Optional<SuperHeroEntity> hero = iservice.getHero(idHero);
//        if(hero.isEmpty() ){
//            throw new ModelNotFoundException("el heroe no fue encontrado");
//        }
//        return ResponseEntity.ok(hero.get());
//    }
//    @GetMapping(value = "/name/{ nameHero} ")
//    public ResponseEntity<List<SuperHeroEntity>>getNameHero(@PathVariable(value = " nameHero") String name){
//        if(name.isBlank() || name == null){
//            throw new FieldHeroEmptyException("campo nombre heroe vacio");
//        }
//        return ResponseEntity.ok(iservice.getNameHero(name.toLowerCase()));
//    }
//
//    @GetMapping("/all")
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseEntity<List<SuperHeroEntity>> getAllHero (){
//        List<SuperHeroEntity> hero =iservice.listHeros();
//        if(hero.isEmpty()){
//            throw new ModelNotFoundException("no se encuentra ningun hero registrado");
//        }
//        return ResponseEntity.ok(hero);
//    }
//
//    @DeleteMapping("/delete/{idHero}")
//    public ResponseEntity<Object> deleteHero(@PathVariable("idHero") Long idHero){
//        Optional<SuperHeroEntity> hero = iservice.getHero(idHero);
//        if(hero.isEmpty() ){
//            throw new ModelNotFoundException("el id no fue encontrado");
//        }
//        iservice.deleteHero(idHero);
//        return  ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/update/{idHero}")
//    public ResponseEntity<Object> updateHero(@RequestBody SuperHeroEntity hero, @PathVariable("idHero") Long idHero){
//        iservice.updateHero(hero,idHero);
//        return ResponseEntity.noContent().build();
//    }

}
