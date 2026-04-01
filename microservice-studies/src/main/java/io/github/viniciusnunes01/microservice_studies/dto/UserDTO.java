package io.github.viniciusnunes01.microservice_studies.dto;

import java.time.LocalDate;

// Objeto de transferência de dados
// Dados imutáveis
public record UserDTO(String name, String email, String password, LocalDate birth) {
	
}
