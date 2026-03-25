package io.github.viniciusnunes01.microservice_studies.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String mensagem() {
		return "Bem-vindo ao meu microserviço!";
	}
}