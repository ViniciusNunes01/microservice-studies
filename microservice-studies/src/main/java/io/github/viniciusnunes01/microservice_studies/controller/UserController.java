package io.github.viniciusnunes01.microservice_studies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.microservice_studies.dto.UserDTO;
import io.github.viniciusnunes01.microservice_studies.model.User;
import io.github.viniciusnunes01.microservice_studies.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User get(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping(value = { "", "/" })
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping("name/{name}")
	public Page<User> getByName(@PathVariable String name, Pageable pageable) {
		return userService.getByName(name, pageable);
	}

	@PostMapping()
	public User create(@Valid @RequestBody UserDTO dto) {
		System.out.println("Criando usuário: " + dto);
		return userService.create(dto);
	}

	@PutMapping("/{id}")
	public String update(@PathVariable String id, @RequestBody String entity) {

		System.out.println("Atualizando Usuário: " + entity);

		return entity;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {

		System.out.println("Deletando Usuário: " + id);

		userService.delete(id);

	}
}
