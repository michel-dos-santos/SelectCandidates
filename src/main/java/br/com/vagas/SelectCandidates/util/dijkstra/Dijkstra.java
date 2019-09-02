package br.com.vagas.SelectCandidates.util.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
	
	public List<Vertice> getMenorCaminho(Grafo grafo, Vertice origem, Vertice destino){
		List<Vertice> menorCaminho = new ArrayList<Vertice>();
		List<Vertice> naoVisitados = new ArrayList<Vertice>();
		
		if(grafo != null && origem != null && destino != null) {
			//add o menor caminho como sendo o ponto de partida
			menorCaminho.add(origem);
			
			//caso a origem seja igual ao destino interrompe o fluxo para ganhar performance 
			if(!origem.equals(destino)) {
				//garante que o ponto de partida seja a menor distancia e marca todos os vertices como não visitado
				grafo.getGrafo().forEach(vertice -> 
					//seta a distancia do ponto de partida como 0, sendo a menor distancia possivel
					vertice.setDistancia(vertice.equals(origem) ? 0 : Long.valueOf(Integer.MAX_VALUE))
				);
				
				//adiciona todos os vertices na lista de nao visitado para controle
				naoVisitados.addAll(grafo.getGrafo());
				
				//ordena o grafo com menor distancia
				Collections.sort(naoVisitados);
				
				//percorre até que todos os vertices sejam visitados
				while (!naoVisitados.isEmpty()) {
					Vertice verticeAtual = naoVisitados.get(0);
					System.out.println("Olhando o vertice: " + verticeAtual);
					
					for (int i = 0; i < verticeAtual.getArestas().size(); i++) {
						Vertice vizinho = verticeAtual.getArestas().get(i).getVerticeDestino();
						System.out.println("Olhando o vizinho de " + verticeAtual + ": " + vizinho);

						long distancia = verticeAtual.getDistancia()+verticeAtual.getArestas().get(i).getPeso();

						//compara a distancia do vizinho com a possivel distancia do vertice atual + peso da aresta
						if(vizinho.getDistancia() > distancia) {
							vizinho.setDistancia(distancia);
							vizinho.setVerticePai(verticeAtual);

							if(vizinho == destino) {
								menorCaminho.clear();
								//variavel que recebe os vertices pertencentes ao menor caminho
								Vertice verticeCaminho = vizinho;
								menorCaminho.add(vizinho);
								while (verticeCaminho.getVerticePai() != null) {
									menorCaminho.add(verticeCaminho.getVerticePai());
									verticeCaminho = verticeCaminho.getVerticePai();
								}
								//ordena o menor caminho, para que ele seja exibido da origem ao destino
								Collections.sort(menorCaminho);
							}
						}
					}
					naoVisitados.remove(verticeAtual);
					//ordena o menor caminho, para que ele seja exibido da origem ao destino
					Collections.sort(menorCaminho);
				}
				
				//caso o mapa seja rotacionado verifica se foi possivel achar o caminho, caso não seja possivel 
				//percorre o grafo a partir da origem ja com as distancias calculadas e ordenadas
				if(menorCaminho.size() == 1 && menorCaminho.get(0).equals(origem)) {
					//ordena o grafo com menor distancia
					Collections.sort(grafo.getGrafo());
					menorCaminho = getMenorCaminho(grafo, origem, destino);
				}
			} else {
				origem.setDistancia(0L);
			}
		}
		
		return menorCaminho;
	}
	
	public Long getMenorDistanciaEntreCandidatoVaga(Grafo grafo, Vertice origem, Vertice destino) {
		//procura o menor caminho entre o candidato e a vaga
		List<Vertice> menorCaminho = getMenorCaminho(grafo, origem, destino);
		
		//calcula a distancia total do menor caminho
		if(!menorCaminho.isEmpty()) {
			return menorCaminho.get(menorCaminho.size()-1).getDistancia();
		}
		
		return null;
		
	}
	
}
