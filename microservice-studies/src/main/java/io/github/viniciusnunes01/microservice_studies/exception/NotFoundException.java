package io.github.viniciusnunes01.microservice_studies.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;
	private String detail;

	public NotFoundException(String message) {
		this.message = message;
	}
}
