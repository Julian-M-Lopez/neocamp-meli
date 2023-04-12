package com.meli.superheroes.controller;

import com.meli.superheroes.model.SuperHeroe;
import com.meli.superheroes.repository.SuperHeroeRepository;
import com.meli.superheroes.service.SuperHeroeService;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
@AllArgsConstructor
public class SuperHeroeController {

    private final SuperHeroeService superHeroeService;
    ;

    @GetMapping
    public List<SuperHeroe> obtenerSuperHeroes() {

        return superHeroeService.getAllSuperHeroes();
    }

    // Buscar superheroe por nombre
    @GetMapping("/{nombre:[a-zA-Z]+}")
    public String obtenerSuperHeroe(@PathVariable("nombre") String nombre) {
        SuperHeroe superHeroe = superHeroeService.getSuperHeroeByNombre(nombre);
        if (superHeroe != null) {
            return "El superhéroe " + superHeroe.getNombre() + " es " + superHeroe.getDescripcion();
        } else {
            return "No se encontró el superhéroe " + nombre;
        }
    }

    // Buscar superheroe por Id
    @GetMapping("/{id:\\d+}")
    public String obtenerSuperHeroePorId(@PathVariable("id") Long id) {
        SuperHeroe superHeroe = superHeroeService.getSuperHeroeById(id);
        if (superHeroe != null) {
            return "El superhéroe " + superHeroe.getNombre() + " es " + superHeroe.getDescripcion();
        } else {
            return "No se encotró el superhéroe con ID: " + id;
        }
    }
    /* Consultar todos los súper héroes que contienen, en su nombre, el valor de un parámetro
    enviado en la petición. Por ejemplo, si enviamos “man” devolverá “Spiderman”, “Superman”,*/

    @GetMapping("/buscar/{nombre}")
    public List<SuperHeroe> buscarSuperHeroesPorNombre(@PathVariable String nombre) {
        if (nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres.");
        }
        List<SuperHeroe> superHeroes = superHeroeService.buscarSuperHeroesPorNombre(nombre);
        return superHeroes;
    }


    //Modificar un súper héroe
    @PutMapping("/{id}")
    public ResponseEntity<SuperHeroe> actualizarSuperHeroe(
            @PathVariable("id") Long id,
            @RequestBody SuperHeroe superHeroeActualizado) {

        SuperHeroe superHeroeExistente = superHeroeService.getSuperHeroeById(id);

        if (superHeroeExistente == null) {
            return ResponseEntity.notFound().build();
        }

        superHeroeExistente = superHeroeService.actualizarSuperHeroe(id, superHeroeActualizado);

        return ResponseEntity.ok(superHeroeExistente);
    }

    //Eliminar un súper héroe

    //Endpoint para eliminar un superhéroe por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperHeroe(@PathVariable Long id) {
        superHeroeService.deleteSuperHeroe(id);
        return ResponseEntity.noContent().build();
    }




}
