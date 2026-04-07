// java
package io.github.viniciusnunes01.microservice_studies.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Msg {
	private String message;
	private Object errors;
	private Object detail;

	public Msg(String message) {
		this.message = message;
	}
}
