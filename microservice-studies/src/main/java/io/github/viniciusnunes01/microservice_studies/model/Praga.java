package io.github.viniciusnunes01.microservice_studies.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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
@Table(name = "tb_praga")
public class Praga extends BaseEntity {

	@Column(nullable = false, length = 100)
	private String nome;

	@Column(length = 150)
	private String nomeCientifico;

	// Uma praga pode ter vários tratamentos recomendados
	@OneToMany(mappedBy = "praga", cascade = CascadeType.ALL)
	private List<Tratamento> tratamentos = new ArrayList<>();
}