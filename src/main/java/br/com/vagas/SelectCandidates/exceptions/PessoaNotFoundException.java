package br.com.vagas.SelectCandidates.exceptions;

public class PessoaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(Long id) {
		super("Não foi possivel encontrar a Pessoa com o ID = " + id);
	}
	
}
