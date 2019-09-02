package br.com.vagas.SelectCandidates.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.vagas.SelectCandidates.domain.Nivel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude="id")
public class Pessoa {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Getter private Long id;
	@Getter @Setter	private String nome;
	@Getter @Setter	private String profissao;
	@Getter @Setter	private Character localizacao;
	@Getter @Setter	@Enumerated(EnumType.ORDINAL) private Nivel nivel;
	
}
