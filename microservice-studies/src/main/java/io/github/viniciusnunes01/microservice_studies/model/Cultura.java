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
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@Table(name = "tb_cultura")
public class Cultura extends BaseEntity {

	@Column(nullable = false, length = 100)
	private String nome;

	// Uma cultura pode ter várias ocorrências de pragas
	@OneToMany(mappedBy = "cultura", cascade = CascadeType.ALL)
	private List<Ocorrencia> ocorrencias = new ArrayList<>();
}