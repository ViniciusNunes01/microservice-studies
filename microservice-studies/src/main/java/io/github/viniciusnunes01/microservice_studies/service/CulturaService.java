package io.github.viniciusnunes01.microservice_studies.service;

import io.github.viniciusnunes01.microservice_studies.model.Cultura;
import io.github.viniciusnunes01.microservice_studies.repository.CulturaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CulturaService {

	private final CulturaRepository culturaRepository;

	public List<Cultura> listAll() {
		return culturaRepository.findAll();
	}

	public Cultura findById(Long id) {
		return culturaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cultura não encontrada com o ID: " + id));
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