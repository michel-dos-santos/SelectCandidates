package br.com.vagas.SelectCandidates.util.dijkstra;

import junit.framework.TestCase;

public class DijkstraTests extends TestCase {

	public void testGetMenorDistancia() {
		Grafo grafo = new Grafo();
		grafo.gerarGrafo();
		
		Vertice origem = grafo.getVertice(new Vertice("A"));
		Vertice destino = grafo.getVertice(new Vertice("B"));
		
		Dijkstra dijkstra = new Dijkstra();
		assertEquals(5L, dijkstra.getMenorDistanciaEntreCandidatoVaga(grafo, origem, destino).longValue());
	}	

	public void testGetMenorDistanciaGrafoNull() {
		Dijkstra dijkstra = new Dijkstra();
		assertTrue(dijkstra.getMenorCaminho(null, new Vertice("A"), new Vertice("B")).isEmpty());
	}
	
	public void testGetMenorDistanciaVerticeOrigemNull() {
		Dijkstra dijkstra = new Dijkstra();
		assertTrue(dijkstra.getMenorCaminho(new Grafo(), null, new Vertice("B")).isEmpty());
	}

	public void testGetMenorDistanciaVerticeDestinoNull() {
		Dijkstra dijkstra = new Dijkstra();
		assertTrue(dijkstra.getMenorCaminho(new Grafo(), new Vertice("A"), null).isEmpty());
	}
	
	public void testGetMenorDistanciaComOrigemDestinoIguais() {
		Grafo grafo = new Grafo();
		grafo.gerarGrafo();
		
		Vertice origem = grafo.getVertice(new Vertice("A"));
		Vertice destino = grafo.getVertice(new Vertice("A"));
		
		Dijkstra dijkstra = new Dijkstra();
		assertEquals(0L, dijkstra.getMenorDistanciaEntreCandidatoVaga(grafo, origem, destino).longValue());
	}	
	
	public void testGetMenorDistanciaComInversaoDeVertice() {
		Grafo grafo = new Grafo();
		grafo.gerarGrafo();
		
		Vertice origem = grafo.getVertice(new Vertice("A"));
		Vertice destino = grafo.getVertice(new Vertice("F"));
		
		Dijkstra dijkstra = new Dijkstra();
		assertEquals(16L, dijkstra.getMenorDistanciaEntreCandidatoVaga(grafo, origem, destino).longValue());
	}
	
	
	
}
