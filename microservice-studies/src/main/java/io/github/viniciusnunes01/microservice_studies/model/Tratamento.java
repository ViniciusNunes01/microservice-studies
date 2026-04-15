package io.github.viniciusnunes01.microservice_studies.model;

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
@Table(name = "tb_tratamento")
public class Tratamento extends BaseEntity {

	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;

	@Column(length = 50)
	private String tipo;

	@ManyToOne
	@JoinColumn(name = "praga_id", nullable = false)
	private Praga praga;
}