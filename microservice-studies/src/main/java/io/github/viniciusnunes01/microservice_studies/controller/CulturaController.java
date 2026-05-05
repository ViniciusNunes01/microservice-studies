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

import io.github.viniciusnunes01.microservice_studies.model.Cultura;
import io.github.viniciusnunes01.microservice_studies.service.CulturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Culturas", description = "Gerenciamento de culturas e plantações")
@RestController
@RequestMapping("/culturas")
@RequiredArgsConstructor
public class CulturaController {

	private final CulturaService culturaService;

	@Operation(summary = "Lista todas as culturas", description = "Retorna uma lista paginada de todas as culturas cadastradas.")
	@GetMapping
	public ResponseEntity<Page<Cultura>> listAll(Pageable pageable) {
		return ResponseEntity.ok(culturaService.listAll(pageable));
	}

	@Operation(summary = "Busca cultura por ID", description = "Retorna uma cultura específica baseada no ID fornecido.")
	@GetMapping("/{id}")
	public ResponseEntity<Cultura> findById(@PathVariable Long id) {
		return ResponseEntity.ok(culturaService.findById(id));
	}

	@Operation(summary = "Cadastra nova cultura", description = "Cria um novo registro de cultura no banco de dados.")
	@PostMapping
	public ResponseEntity<Cultura> create(@Valid @RequestBody Cultura cultura) {
		Cultura novaCultura = culturaService.create(cultura);
		// Retorna 201 Created em caso de sucesso na inserção
		return ResponseEntity.status(HttpStatus.CREATED).body(novaCultura);
	}

	@Operation(summary = "Atualiza uma cultura", description = "Atualiza os dados de uma cultura existente informando o ID.")
	@PutMapping("/{id}")
	public ResponseEntity<Cultura> update(@PathVariable Long id, @Valid @RequestBody Cultura cultura) {
		return ResponseEntity.ok(culturaService.update(id, cultura));
	}

	@Operation(summary = "Deleta uma cultura", description = "Remove permanentemente uma cultura do sistema.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		culturaService.delete(id);
		// Retorna 204 No Content quando deleta com sucesso
		return ResponseEntity.noContent().build();
	}
}