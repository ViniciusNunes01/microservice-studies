package io.github.viniciusnunes01.microservice_studies.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@GetMapping("/{id}")
	public String get(@PathVariable Long id) {
		return "Juca Bala (ID: " + id + ")";
	}

	@GetMapping
	public String getAll() {
		return "['Juca Bala', 'Priscila Araujo', 'Zé da Pinga']";
	}

	@PostMapping()
	public String create(@RequestBody String entity) {

		System.out.println(entity);

		return entity;
	}

	@PutMapping("/{id}")
	public String update(@PathVariable String id, @RequestBody String entity) {

		System.out.println("Atualizando Usuário: " + entity);

		return entity;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {

		System.out.println("Deletando Usuário: " + id);

	}
}
