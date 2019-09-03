package br.com.vagas.SelectCandidates.util.dijkstra;

import static org.mockito.Mockito.when;

import org.mockito.Mockito;

import junit.framework.TestCase;

public class GrafoTests extends TestCase {

	public void testGerarGrafoSemMapa() {
		Grafo grafo = Mockito.mock(Grafo.class);
		when(grafo.getInputStreamMapa()).thenReturn(null);
		grafo.gerarGrafo();
		assertTrue(grafo.getGrafo().isEmpty());
	}
	
	public void testGerarGrafoComMapa() {
		Grafo grafo = new Grafo();
		grafo.gerarGrafo();
		assertFalse(grafo.getGrafo().isEmpty());
		assertNull(grafo.getVertice(null));
		assertNull(grafo.getVertice(new Vertice("Test")));
		assertNotNull(grafo.getVertice(new Vertice("A"))); 
	}

}
