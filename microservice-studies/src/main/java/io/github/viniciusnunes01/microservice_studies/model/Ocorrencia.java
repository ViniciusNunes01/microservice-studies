package io.github.viniciusnunes01.microservice_studies.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_ocorrencia")
public class Ocorrencia extends BaseEntity {

	@NotBlank(message = "O local da ocorrência é obrigatório.")
	@Size(max = 100, message = "O local deve ter no máximo 100 caracteres.")
	@Column(length = 100)
	private String local;

	@NotNull(message = "A data de observação é obrigatória.")
	@PastOrPresent(message = "A data não pode ser no futuro.")
	@Column(nullable = false)
	private LocalDate dataObservacao;

	@NotBlank(message = "A gravidade deve ser informada (Ex: Baixa, Média, Alta).")
	@Size(max = 50, message = "A gravidade deve ter no máximo 50 caracteres.")
	@Column(length = 50)
	private String gravidade;

	@NotNull(message = "A cultura relacionada é obrigatória.")
	@ManyToOne
	@JoinColumn(name = "cultura_id", nullable = false)
	private Cultura cultura;

	@NotNull(message = "A praga relacionada é obrigatória.")
	@ManyToOne
	@JoinColumn(name = "praga_id", nullable = false)
	private Praga praga;
}