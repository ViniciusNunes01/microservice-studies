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

import io.github.viniciusnunes01.microservice_studies.model.Tratamento;
import io.github.viniciusnunes01.microservice_studies.service.TratamentoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/tratamentos")
@RequiredArgsConstructor
public class TratamentoController {

	private final TratamentoService tratamentoService;

	// Teste: http://localhost:8080/tratamentos?page=0&size=10
	@GetMapping
	public ResponseEntity<Page<Tratamento>> listAll(Pageable pageable) {
		return ResponseEntity.ok(tratamentoService.listAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tratamento> findById(@PathVariable Long id) {
		return ResponseEntity.ok(tratamentoService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Tratamento> create(@RequestBody Tratamento tratamento) {
		Tratamento novoTratamento = tratamentoService.create(tratamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoTratamento);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Tratamento> update(@PathVariable Long id, @RequestBody Tratamento tratamento) {
		return ResponseEntity.ok(tratamentoService.update(id, tratamento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		tratamentoService.delete(id);
		// Retorna 204 No Content quando deleta com sucesso
		return ResponseEntity.noContent().build();
	}
}