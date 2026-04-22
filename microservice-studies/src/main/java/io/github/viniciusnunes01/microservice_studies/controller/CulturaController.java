package io.github.viniciusnunes01.microservice_studies.controller;

import io.github.viniciusnunes01.microservice_studies.model.Cultura;
import io.github.viniciusnunes01.microservice_studies.service.CulturaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/culturas")
@RequiredArgsConstructor
public class CulturaController {

    private final CulturaService culturaService;

    // Teste: http://localhost:8080/culturas?page=0&size=10
    @GetMapping
    public ResponseEntity<Page<Cultura>> listAll(Pageable pageable) {
        return ResponseEntity.ok(culturaService.listAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cultura> findById(@PathVariable Long id) {
        return ResponseEntity.ok(culturaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cultura> create(@RequestBody Cultura cultura) {
        Cultura novaCultura = culturaService.create(cultura);
        // Retorna 201 Created em caso de sucesso na inserção
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCultura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cultura> update(@PathVariable Long id, @RequestBody Cultura cultura) {
        return ResponseEntity.ok(culturaService.update(id, cultura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        culturaService.delete(id);
        // Retorna 204 No Content quando deleta com sucesso
        return ResponseEntity.noContent().build();
    }
}