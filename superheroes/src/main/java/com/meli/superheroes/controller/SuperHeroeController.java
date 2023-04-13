package com.meli.superheroes.controller;

import com.meli.superheroes.model.SuperHeroe;
import com.meli.superheroes.service.SuperHeroeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<SuperHeroe> obtenerSuperHeroePorId(@PathVariable("id") Long id) {
        SuperHeroe superHeroe = superHeroeService.getSuperHeroeById(id);
        if (superHeroe != null) {
            return ResponseEntity.ok(superHeroe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Metodo POST para añadir un superheroe a la base de datos
    @PostMapping("/agregar")
    public ResponseEntity<SuperHeroe> agregarSuperHeroe(@RequestBody SuperHeroe superHeroe) {
        SuperHeroe superHeroeCreado = superHeroeService.saveSuperHeroe(superHeroe);
        if (superHeroeCreado != null) {
            // Crear una respuesta HTTP con código de estado 201 Created y el superhéroe creado en el cuerpo de la respuesta
            return ResponseEntity.created(URI.create("/superheroes/" + superHeroeCreado.getId()))
                    .body(superHeroeCreado);
        } else {
            // En caso de que no se pueda crear el superhéroe, devolver una respuesta HTTP con código de estado 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }



    /* Consultar todos los súper héroes que contienen, en su nombre, el valor de un parámetro
    enviado en la petición. Por ejemplo, si enviamos “man” devolverá “Spiderman”, “Superman”,*/

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<List<SuperHeroe>>buscarSuperHeroesPorNombre(@PathVariable String nombre) {
        if (nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres.");
        }
        List<SuperHeroe> superHeroes = superHeroeService.buscarSuperHeroesPorNombre(nombre);
        return ResponseEntity.ok(superHeroes);

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
