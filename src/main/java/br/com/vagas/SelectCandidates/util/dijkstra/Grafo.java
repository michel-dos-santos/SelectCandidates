package br.com.vagas.SelectCandidates.util.dijkstra;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Grafo {

	private List<Vertice> grafo = new ArrayList<Vertice>();
	
	public Grafo(){
		gerarGrafo();
	}
	
	public Vertice getVertice(Vertice vertice) {
		int index = -1;
		if(vertice != null && (index = grafo.indexOf(vertice)) >= 0) {
			return grafo.get(index);
		}
		return null;
	}
	
	public List<Vertice> getGrafo() {
		return grafo;
	}
	
	private void gerarGrafo() {
		Properties mapa = new Properties();
		InputStream inputStream = Grafo.class.getClassLoader().getResourceAsStream("mapa.properties");

		try {
			if (inputStream != null) {
				mapa.load(inputStream);
				Map<String, Vertice> map = new HashMap<String, Vertice>();
				
				mapa.keys().asIterator().forEachRemaining(key -> {
					List<String> vertices = Arrays.asList(((String) key).split(","));
					if(!vertices.isEmpty()) {
						String verticeOrigem = vertices.get(0);
						Vertice verticePai = (Vertice) map.get(verticeOrigem);
						if (verticePai == null) {
							verticePai = new Vertice(verticeOrigem);
						}
						
						List<Vertice> vizinhos = new ArrayList<Vertice>();
						List<Aresta> arestas = new ArrayList<Aresta>();
						map.put(verticeOrigem, verticePai);
						
						String value = mapa.getProperty((String) key);
						List<String> pesos = Arrays.asList((value).split(","));
						
						for (int i = 1; i < vertices.size(); i++) {
							String vertice = vertices.get(i);
							Vertice verticeVizinho = (Vertice) map.get(vertice);
							if (verticeVizinho == null) {
								verticeVizinho = new Vertice(vertice);
							}
							vizinhos.add(verticeVizinho);
							map.put(vertice, verticeVizinho);

							Aresta aresta = new Aresta(verticePai, verticeVizinho);
							aresta.setPeso(Long.parseLong(pesos.get(i-1).trim()));
							arestas.add(aresta);
						}
						
						verticePai.setArestas(arestas);
						grafo.add(verticePai);
					}
				});
				
			} 

			inputStream.close();
		} catch (IOException e) {
			//TODO
		}
	}

	public static void main(String args[]) {
		Grafo teste = new Grafo();
		Vertice i1 = teste.getVertice(new Vertice("C"));
		Vertice i2 = teste.getVertice(new Vertice("A"));

		List<Vertice> resultado = new ArrayList<Vertice>();
		Dijkstra algoritmo = new Dijkstra();
		resultado = algoritmo.getMenorCaminho(teste, i1, i2);
		Long distancia = algoritmo.getMenorDistanciaEntreCandidatoVaga(teste, i1, i2);
		
		System.out.println("Esse é o menor caminho feito pelo algoritmo:" + resultado);
		System.out.println("Esse é a menor distancia:" + distancia);
	}
	
}
