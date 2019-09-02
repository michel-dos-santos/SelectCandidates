package br.com.vagas.SelectCandidates.model.response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.vagas.SelectCandidates.domain.Nivel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class VagaResponse {

	@Getter @Setter	private String empresa;
	@Getter @Setter	private String titulo;
	@Getter @Setter	private String descricao;
	@Getter @Setter	private Character localizacao;
	@Getter @Setter	@Enumerated(EnumType.ORDINAL) private Nivel nivel;
	
}
