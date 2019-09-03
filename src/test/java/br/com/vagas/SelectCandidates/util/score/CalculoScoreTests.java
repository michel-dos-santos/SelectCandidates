package br.com.vagas.SelectCandidates.util.score;

import br.com.vagas.SelectCandidates.domain.Nivel;
import br.com.vagas.SelectCandidates.model.entity.Pessoa;
import br.com.vagas.SelectCandidates.model.entity.Vaga;
import junit.framework.TestCase;

public class CalculoScoreTests extends TestCase {

	public void testGetScoreCandidatoVaga() {
		Pessoa pessoa = Pessoa.builder()
				.localizacao(Character.valueOf('C'))
				.nivel(Nivel.Especialista)
				.build();
		
		Vaga vaga = Vaga.builder()
				.localizacao(Character.valueOf('A'))
				.nivel(Nivel.Pleno)
				.build();
		
		assertEquals(100, CalculoScore.getScoreCandidatoVaga(pessoa, vaga).intValue());
	
	}

	public void testGetRelacaoMenorDistanciaCandidatoVaga5() {
		assertEquals(100, CalculoScore.getRelacaoEntreMenorDistanciaCandidatoVaga(5L).intValue());
	}
	
	public void testGetRelacaoMenorDistanciaCandidatoVaga10() {
		assertEquals(75, CalculoScore.getRelacaoEntreMenorDistanciaCandidatoVaga(10L).intValue());
	}
	
	public void testGetRelacaoMenorDistanciaCandidatoVaga15() {
		assertEquals(50, CalculoScore.getRelacaoEntreMenorDistanciaCandidatoVaga(15L).intValue());
	}
	
	public void testGetRelacaoMenorDistanciaCandidatoVaga20() {
		assertEquals(25, CalculoScore.getRelacaoEntreMenorDistanciaCandidatoVaga(20L).intValue());
	}
	
	public void testGetRelacaoMenorDistanciaCandidatoVaga25() {
		assertEquals(0, CalculoScore.getRelacaoEntreMenorDistanciaCandidatoVaga(25L).intValue());
	}
}
