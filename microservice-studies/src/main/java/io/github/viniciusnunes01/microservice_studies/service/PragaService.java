package io.github.viniciusnunes01.microservice_studies.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.microservice_studies.model.Praga;
import io.github.viniciusnunes01.microservice_studies.repository.PragaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PragaService {

	private final PragaRepository pragaRepository;

	public Page<Praga> listAll(Pageable pageable) {
		return pragaRepository.findAll(pageable);
	}

	public Praga findById(Long id) {
		return pragaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Praga não encontrada com o ID: " + id));
	}

	public Praga create(Praga praga) {
		return pragaRepository.save(praga);
	}

	public Praga update(Long id, Praga pragaAtualizada) {
		Praga pragaExistente = findById(id);
		pragaExistente.setNome(pragaAtualizada.getNome());
		pragaExistente.setNomeCientifico(pragaAtualizada.getNomeCientifico());
		return pragaRepository.save(pragaExistente);
	}

	public void delete(Long id) {
		Praga pragaExistente = findById(id);
		pragaRepository.delete(pragaExistente);
	}
}