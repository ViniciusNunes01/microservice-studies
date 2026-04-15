package io.github.viniciusnunes01.microservice_studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.viniciusnunes01.microservice_studies.model.Praga;

@Repository
public interface PragaRepository extends JpaRepository<Praga, Long> {
}