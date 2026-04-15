package io.github.viniciusnunes01.microservice_studies.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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

	@Column(length = 100)
	private String local;

	@Column(nullable = false)
	private LocalDate dataObservacao;

	@Column(length = 50)
	private String gravidade;

	@ManyToOne
	@JoinColumn(name = "cultura_id", nullable = false)
	private Cultura cultura;

	@ManyToOne
	@JoinColumn(name = "praga_id", nullable = false)
	private Praga praga;
}