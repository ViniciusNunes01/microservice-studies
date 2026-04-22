package io.github.viniciusnunes01.microservice_studies.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.viniciusnunes01.microservice_studies.model.Praga;
import io.github.viniciusnunes01.microservice_studies.service.PragaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pragas")
@RequiredArgsConstructor
public class PragaController {

	private final PragaService pragaService;

	// Teste: http://localhost:8080/pragas?page=0&size=10
	@GetMapping
	public ResponseEntity<Page<Praga>> listAll(Pageable pageable) {
		return ResponseEntity.ok(pragaService.listAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Praga> findById(@PathVariable Long id) {
		return ResponseEntity.ok(pragaService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Praga> create(@RequestBody Praga praga) {
		Praga novaPraga = pragaService.create(praga);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaPraga);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Praga> update(@PathVariable Long id, @RequestBody Praga praga) {
		return ResponseEntity.ok(pragaService.update(id, praga));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pragaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}