package com.helloworld.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	@GetMapping
	public String hello() {
		return "Hello World!!! Para essa atividade eu utilizei a Mentalidade de PERSISTÊNCIA e a Habilidade de ATENÇÃO AOS DETALHES!";
	}
	
}
