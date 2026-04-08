package io.github.viniciusnunes01.microservice_studies.service;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.viniciusnunes01.microservice_studies.dto.UserDTO;
import io.github.viniciusnunes01.microservice_studies.exception.NotFoundException;
import io.github.viniciusnunes01.microservice_studies.model.User;
import io.github.viniciusnunes01.microservice_studies.repository.UserRepository;
import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User create(UserDTO dto) {

		// Instanciando uma entidade JPA
		User user = new User();

		// Copia as propriedades do DTO para a entidade JPA
		BeanUtils.copyProperties(dto, user);

		// Persistir a entidade JPA
		return userRepository.save(user);

	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Usuário não encontrado!"));
	}

	public void delete(Long id) {
		userRepository.deleteById(id);
	}

	public Page<User> getByName(String name, Pageable pageable) {
		return userRepository.findByNameContainingIgnoreCase(name, pageable);
	}

	public @Nullable Object update(@Valid Long id, UserDTO dto) {

		var entity = findById(id);

		BeanUtils.copyProperties(dto, entity, "id, password"); // Copia as propriedades do dto para a entidade,
																// ignorando id e password
		return userRepository.save(entity);
	}
}
