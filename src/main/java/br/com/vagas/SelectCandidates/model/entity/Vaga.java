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

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vaga {

	@Id @GeneratedValue(strategy = GenerationType.AUTO) @Getter private Long id;
	@Getter @Setter	private String empresa;
	@Getter @Setter	private String titulo;
	@Getter @Setter	private String descricao;
	@Getter @Setter	private Character localizacao;
	@Getter @Setter	@Enumerated(EnumType.ORDINAL) private Nivel nivel;
	
}
