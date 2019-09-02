package br.com.vagas.SelectCandidates.model.response;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.vagas.SelectCandidates.domain.Nivel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class PessoaResponse {

	@Getter @Setter	private String nome;
	@Getter @Setter	private String profissao;
	@Getter @Setter	private Character localizacao;
	@Getter @Setter	@Enumerated(EnumType.ORDINAL) private Nivel nivel;
	
}
