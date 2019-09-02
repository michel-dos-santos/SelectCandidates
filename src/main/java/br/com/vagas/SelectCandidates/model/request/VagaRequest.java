package br.com.vagas.SelectCandidates.model.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.vagas.SelectCandidates.domain.Nivel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class VagaRequest {

	@Getter @Setter	private String empresa;
	@Getter @Setter	private String titulo;
	@Getter @Setter	private String descricao;
	@Getter @Setter	private Character localizacao;
	@Getter @Setter	@Enumerated(EnumType.ORDINAL) private Nivel nivel;
	
}
