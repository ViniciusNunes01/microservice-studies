package io.github.viniciusnunes01.microservice_studies.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.microservice_studies.model.Ocorrencia;
import io.github.viniciusnunes01.microservice_studies.repository.OcorrenciaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OcorrenciaService {

	private final OcorrenciaRepository ocorrenciaRepository;

	public Page<Ocorrencia> listAll(Pageable pageable) {
		return ocorrenciaRepository.findAll(pageable);
	}

	public Ocorrencia findById(Long id) {
		return ocorrenciaRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Ocorrencia não encontrada com o ID: " + id));
	}

	public Ocorrencia create(Ocorrencia ocorrencia) {
		return ocorrenciaRepository.save(ocorrencia);
	}

	public Ocorrencia update(Long id, Ocorrencia ocorrenciaAtualizada) {
		Ocorrencia ocorrenciaExistente = findById(id);
		ocorrenciaExistente.setLocal(ocorrenciaAtualizada.getLocal());
		ocorrenciaExistente.setDataObservacao(ocorrenciaAtualizada.getDataObservacao());
		ocorrenciaExistente.setGravidade(ocorrenciaAtualizada.getGravidade());
		return ocorrenciaRepository.save(ocorrenciaExistente);
	}

	public void delete(Long id) {
		Ocorrencia ocorrenciaExistente = findById(id);
		ocorrenciaRepository.delete(ocorrenciaExistente);
	}
}