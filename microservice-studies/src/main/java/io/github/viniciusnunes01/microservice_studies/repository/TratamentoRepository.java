package io.github.viniciusnunes01.microservice_studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.viniciusnunes01.microservice_studies.model.Tratamento;

@Repository
public interface TratamentoRepository extends JpaRepository<Tratamento, Long> {
}