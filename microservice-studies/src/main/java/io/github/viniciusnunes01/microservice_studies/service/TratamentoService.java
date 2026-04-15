package io.github.viniciusnunes01.microservice_studies.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.microservice_studies.model.Tratamento;
import io.github.viniciusnunes01.microservice_studies.repository.TratamentoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TratamentoService {

	private final TratamentoRepository tratamentoRepository;

	public List<Tratamento> listAll() {
		return tratamentoRepository.findAll();
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