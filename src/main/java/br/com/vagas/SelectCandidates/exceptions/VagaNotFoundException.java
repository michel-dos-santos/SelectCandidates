package br.com.vagas.SelectCandidates.exceptions;

public class VagaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VagaNotFoundException(Long id) {
		super("Não foi possivel encontrar a Vaga com o ID = " + id);
	}
	
}
