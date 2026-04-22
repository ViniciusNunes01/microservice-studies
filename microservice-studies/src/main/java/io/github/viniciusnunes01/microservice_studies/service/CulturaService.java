package io.github.viniciusnunes01.microservice_studies.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import io.github.viniciusnunes01.microservice_studies.model.Cultura;
import io.github.viniciusnunes01.microservice_studies.repository.CulturaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CulturaService {

	private final CulturaRepository culturaRepository;

	public Page<Cultura> listAll(Pageable pageable) {
		return culturaRepository.findAll(pageable);
	}

	public Cultura findById(Long id) {
		return culturaRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cultura não encontrada com o ID: " + id));
	}

	public Cultura create(Cultura cultura) {
		return culturaRepository.save(cultura);
	}

	public Cultura update(Long id, Cultura culturaAtualizada) {
		Cultura culturaExistente = findById(id);
		culturaExistente.setNome(culturaAtualizada.getNome());
		return culturaRepository.save(culturaExistente);
	}

	public void delete(Long id) {
		Cultura culturaExistente = findById(id);
		culturaRepository.delete(culturaExistente);
	}
}