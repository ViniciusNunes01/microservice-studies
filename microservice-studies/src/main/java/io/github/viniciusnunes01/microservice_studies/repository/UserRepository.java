package io.github.viniciusnunes01.microservice_studies.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import io.github.viniciusnunes01.microservice_studies.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByEmail(String email);

    // Método para fazer busca dos usuários pelo nome (sem case sensitive)
	public Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
}
