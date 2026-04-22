package io.github.viniciusnunes01.microservice_studies.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.microservice_studies.model.Tratamento;
import io.github.viniciusnunes01.microservice_studies.repository.TratamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TratamentoService {

	private final TratamentoRepository tratamentoRepository;

	public Page<Tratamento> listAll(Pageable pageable) {
		return tratamentoRepository.findAll(pageable);
	}

	public Tratamento findById(Long id) {
		return tratamentoRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Tratamento não encontrado com o ID: " + id));
	}

	public Tratamento create(Tratamento tratamento) {
		return tratamentoRepository.save(tratamento);
	}

	public Tratamento update(Long id, Tratamento tratamentoAtualizado) {
		Tratamento tratamentoExistente = findById(id);
		tratamentoExistente.setDescricao(tratamentoAtualizado.getDescricao());
		tratamentoExistente.setTipo(tratamentoAtualizado.getTipo());
		return tratamentoRepository.save(tratamentoExistente);
	}

	public void delete(Long id) {
		Tratamento tratamentoExistente = findById(id);
		tratamentoRepository.delete(tratamentoExistente);
	}
}