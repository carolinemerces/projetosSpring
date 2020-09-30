package com.helloworld.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldObjetivosController {
	
	@GetMapping
	public String hello(){
		return "Hello World!!! Os objetivos de aprendizem dessa semana é fazer aplicações Spring-boot, utilizando STS e Postman!";
	}

}
