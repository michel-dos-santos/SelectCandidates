package br.com.vagas.SelectCandidates.util.dijkstra;

import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode
@ToString(exclude = {"distancia", "verticePai", "arestas"})
public class Vertice implements Comparable<Vertice>{

	@Getter @Setter private String nome;
	@Getter @Setter @EqualsAndHashCode.Exclude private Long distancia = Long.valueOf(Integer.MAX_VALUE);
	@Getter @Setter @EqualsAndHashCode.Exclude private Vertice verticePai;
	@Getter @Setter @EqualsAndHashCode.Exclude private List<Aresta> arestas = new ArrayList<Aresta>();
	
	public Vertice(String nome) {
		this.nome = nome;
	}

	@Override
	public int compareTo(Vertice vertice) {
		if(this.getDistancia() < vertice.getDistancia()) {
			return -1;
		} else if(this.getDistancia() == vertice.getDistancia()) {
			return 0;
		}

		return 1;
	}
	
}
