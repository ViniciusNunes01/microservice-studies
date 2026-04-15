package io.github.viniciusnunes01.microservice_studies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.viniciusnunes01.microservice_studies.model.Cultura;

@Repository
public interface CulturaRepository extends JpaRepository<Cultura, Long> {
}