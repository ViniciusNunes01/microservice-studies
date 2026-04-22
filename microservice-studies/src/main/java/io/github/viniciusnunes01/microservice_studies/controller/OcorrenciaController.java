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

import io.github.viniciusnunes01.microservice_studies.model.Ocorrencia;
import io.github.viniciusnunes01.microservice_studies.service.OcorrenciaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ocorrencias")
@RequiredArgsConstructor
public class OcorrenciaController {

	private final OcorrenciaService ocorrenciaService;

	// Teste: http://localhost:8080/ocorrencias?page=0&size=10
	@GetMapping
	public ResponseEntity<Page<Ocorrencia>> listAll(Pageable pageable) {
		return ResponseEntity.ok(ocorrenciaService.listAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ocorrencia> findById(@PathVariable Long id) {
		return ResponseEntity.ok(ocorrenciaService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Ocorrencia> create(@RequestBody Ocorrencia ocorrencia) {
		Ocorrencia novaOcorrencia = ocorrenciaService.create(ocorrencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(novaOcorrencia);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ocorrencia> update(@PathVariable Long id, @RequestBody Ocorrencia ocorrencia) {
		return ResponseEntity.ok(ocorrenciaService.update(id, ocorrencia));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		ocorrenciaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}