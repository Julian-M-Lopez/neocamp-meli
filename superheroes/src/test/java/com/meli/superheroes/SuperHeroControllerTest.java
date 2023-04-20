package com.meli.superheroes;

import com.meli.superheroes.adapter.in.controller.SuperHeroController;
import com.meli.superheroes.application.port.in.SuperHeroPortIn;
import com.meli.superheroes.domain.model.SuperHero;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

public class SuperHeroControllerTest {


    @Mock
    private SuperHeroPortIn superHeroPortIn;

    private SuperHeroController superHeroController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        superHeroController = new SuperHeroController(superHeroPortIn);
    }

    //Prueba metodo GET SuperHeroById
    @Test
    void givenExistingSuperHeroId_thenReturnSuperHero(){
        // arrange

        SuperHero superHero = new SuperHero();
        superHero.setName("Superman");
        superHero.setDescription("Man of Steel");
        superHero.setCapa(true);

        when(superHeroPortIn.getSuperHeroById(anyLong())).thenReturn(superHero);

        //act
        ResponseEntity<SuperHero> responseEntity = superHeroController.getHeroById(1L);

        //assert
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        Assertions.assertEquals(superHero, responseEntity.getBody());

    }
    @Test
    void givenNonesistenSuperHeroId_thenReturnNotFound(){
        // Arrange
        Long id =1L;

        // Se simula que no se encuentra un superhéroe con ese ID en la base de datos
        when(superHeroPortIn.getSuperHeroById(anyLong())).thenReturn(null);

        ResponseEntity<SuperHero> responseEntity = superHeroController.getHeroById(id);

        // Assert
        // Se comprueba que se haya devuelto un código de estado NOT_FOUND
        Assertions.assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        // Se comprueba que no se haya devuelto ningún objeto SuperHero
        Assertions.assertNull(responseEntity.getBody());

    }




}
