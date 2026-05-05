package io.github.viniciusnunes01.microservice_studies.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "tb_praga")
public class Praga extends BaseEntity {

	@NotBlank(message = "O nome da praga é obrigatório.")
	@Size(min = 2, max = 100, message = "O nome deve ter entre 2 e 100 caracteres.")
	@Column(nullable = false, length = 100)
	private String nome;

	// Deixei sem @NotBlank porque o campo no banco não é nullable=false (pode ser opcional)
	// Mas limitamos o tamanho para evitar erros no banco.
	@Size(max = 150, message = "O nome científico deve ter no máximo 150 caracteres.")
	@Column(length = 150)
	private String nomeCientifico;

	@OneToMany(mappedBy = "praga", cascade = CascadeType.ALL)
	private List<Tratamento> tratamentos = new ArrayList<>();
}