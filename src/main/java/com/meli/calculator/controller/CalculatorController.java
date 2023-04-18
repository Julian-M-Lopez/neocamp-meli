package com.meli.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

	@GetMapping("/sumar")
	public int sumar(@RequestParam("a") int a, @RequestParam("b") int b) {
		return a + b;
	}

	@GetMapping("/restar")
	public int restar(@RequestParam("a") int a, @RequestParam("b") int b) {
		return a - b;
	}

	@GetMapping("/multiplicar")
	public int multiplicar(@RequestParam("a") int a, @RequestParam("b") int b) {
		return a * b;
	}

	@GetMapping("/dividir")
	public double dividir(@RequestParam("a") double a, @RequestParam("b") double b) {
		if (b == 0) {
			throw new IllegalArgumentException("No se puede dividir por cero");
		}
		return a / b;
	}
}
