package com.meli.superheroes.adapter.in.controller;

import com.meli.superheroes.application.port.in.SuperHeroPortIn;
import com.meli.superheroes.common.common.WebAdapter;
import com.meli.superheroes.domain.model.SuperHero;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@WebAdapter
@RestController
@RequestMapping("/superheroes")
@AllArgsConstructor

public class SuperHeroController {
    private final SuperHeroPortIn superHeroPortIn;

    // Metodo GET Buscar superheroe por Id
    @GetMapping("/{id:\\d+}")
    public ResponseEntity<SuperHero> getHeroById(@PathVariable Long id) {
        SuperHero superHero = superHeroPortIn.getSuperHeroById(id);
        if (superHero != null) {
            return ResponseEntity.ok(superHero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    //Metodo GET para devolver un listado de superheroes de la base de datos
    @GetMapping("/list")
    public ResponseEntity<List<SuperHero>> getAllHeroes() {
        return new ResponseEntity<>(superHeroPortIn.getAllSuperHeroes(), HttpStatus.OK);
    }

    //Metodo POST para añadir un superheroe a la base de datos
    @PostMapping("/add")
    public ResponseEntity<SuperHero> addHero(@RequestBody SuperHero superHero){
        superHero.setName(superHero.getName().toLowerCase());
        return new ResponseEntity<>(superHeroPortIn.addSuperHero(superHero), HttpStatus.CREATED);
    }

     /* Consultar todos los súper héroes que contienen, en su nombre, el valor de un parámetro
    enviado en la petición. Por ejemplo, si enviamos “man” devolverá “Spiderman”, “Superman”,*/

    @GetMapping("/search/{name}")
    public ResponseEntity<List<SuperHero>>findHeroByName(@PathVariable String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres.");
        }
        return new ResponseEntity<>(superHeroPortIn.findHeroByName(name), HttpStatus.OK);

    }

    //Metodo PUT para modificar un súper héroe
    @PutMapping("/update/{id}")
    public ResponseEntity<SuperHero> actualizarSuperHeroe(@PathVariable("id") Long id, @RequestBody SuperHero superHeroeActualizado) {

        SuperHero superHeroeExistente = superHeroPortIn.getSuperHeroById(id);

        if (superHeroeExistente == null) {
            return ResponseEntity.notFound().build();
        }

        superHeroeExistente = superHeroPortIn.updateSuperHero(id, superHeroeActualizado);

        return ResponseEntity.ok(superHeroeExistente);
    }


    //Metodo DELETE para eliminar un superhéroe por ID

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSuperHeroe(@PathVariable Long id) {
        superHeroPortIn.deleteSuperHero(id);
        return ResponseEntity.noContent().build();
    }


}
