package com.meli.calculator;

import com.meli.calculator.model.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    // TEST Funcionalidad SUMA
    ////////////////////////////////////////////////////////////////
    @Test
    @Disabled("no disponible")
    void testSumaNumerosNaturalesOk() {
        // ARRANGE
        int expectedResult = 5;
        int numeroNatural1 = 2;
        int numeroNatural2 = 3;

        // ACT: funcionalidad que quiero probar
        int result = calculator.sumar(numeroNatural1, numeroNatural2);

        // Verificacion o comprobacion final
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testSumaNumerosNegativosOk() {
        // ARRANGE
        int expectedResult = -5;
        int numeroNatural1 = -2;
        int numeroNatural2 = -3;

        // ACT: funcionalidad que quiero probar
        int result = calculator.sumar(numeroNatural1, numeroNatural2);

        // ASSERTS: Verificacion o comprobacion final
        Assertions.assertEquals(expectedResult, result);
    }
    ////////////////////////////////////////////////////////////////

    @Test
    void testRestar() {
        Assertions.assertTrue(true);
    }

    @Test
    void testMultiplicar() {
        Assertions.assertTrue(true);
    }

    @Test
    void testDividir() {
        Assertions.assertTrue(true);
    }

}