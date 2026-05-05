package io.github.viniciusnunes01.microservice_studies.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "tb_tratamento")
public class Tratamento extends BaseEntity {

	@NotBlank(message = "A descrição do tratamento é obrigatória.")
	@Column(nullable = false, columnDefinition = "TEXT")
	private String descricao;

	@NotBlank(message = "O tipo do tratamento é obrigatório (Ex: Químico, Biológico).")
	@Size(max = 50, message = "O tipo deve ter no máximo 50 caracteres.")
	@Column(length = 50)
	private String tipo;

	@NotNull(message = "A praga relacionada é obrigatória.")
	@ManyToOne
	@JoinColumn(name = "praga_id", nullable = false)
	private Praga praga;
}