package br.com.vagas.SelectCandidates.exceptions;

public class CandidaturaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CandidaturaNotFoundException(Long id) {
		super("Não foi possivel encontrar a Candidatura com o ID = " + id);
	}
	
}
