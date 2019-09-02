package br.com.vagas.SelectCandidates.util.dijkstra;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Aresta {
	
	@Getter @Setter private Long peso;
	@Getter @Setter private Vertice verticeOrigem;
	@Getter @Setter private Vertice verticeDestino;
	
	public Aresta(Vertice verticeOrigem, Vertice verticeDestino) {
		this.peso = 1L;
		this.verticeOrigem = verticeOrigem;
		this.verticeDestino = verticeDestino;
	}

}
