package br.com.vagas.SelectCandidates.util.score;

import br.com.vagas.SelectCandidates.model.entity.Pessoa;
import br.com.vagas.SelectCandidates.model.entity.Vaga;
import br.com.vagas.SelectCandidates.util.dijkstra.Dijkstra;
import br.com.vagas.SelectCandidates.util.dijkstra.Grafo;
import br.com.vagas.SelectCandidates.util.dijkstra.Vertice;

public class CalculoScore {

	public static Integer getScoreCandidatoVaga(Pessoa candidato, Vaga vaga) {
		
		//obtem distancia entre o candidato e a vaga com menor caminha possivel
		Grafo grafo = new Grafo();
		Dijkstra dijkstra = new Dijkstra();
		Long distanciaEntreCandidatoVaga = dijkstra.getMenorDistanciaEntreCandidatoVaga(grafo, grafo.getVertice(new Vertice(candidato.getLocalizacao().toString())), grafo.getVertice(new Vertice(vaga.getLocalizacao().toString())));
		Integer distancia = getRelacaoEntreMenorDistanciaCandidatoVaga(distanciaEntreCandidatoVaga);
		
		Integer nivel = 100 - 25 * ((vaga.getNivel().ordinal()+1) - (candidato.getNivel().ordinal()+1));
		
		return (nivel + distancia) / 2;
	}

	private static Integer getRelacaoEntreMenorDistanciaCandidatoVaga(Long distanciaEntreCandidatoVaga) {
		
		if(distanciaEntreCandidatoVaga <= 5){
			return 100;
		} else if(distanciaEntreCandidatoVaga <= 10){
			return 75;
		} else if(distanciaEntreCandidatoVaga <= 15){
			return 50;
		} else if(distanciaEntreCandidatoVaga <= 20){
			return 25;
		} 
		
		return 0;
	}
}
