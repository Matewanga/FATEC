package com.nickolss.ex05;

import java.util.*;

// Classe que representa um Grafo não direcionado
public class Grafo {
    private final int vertices;
    private final List<List<Integer>> adjacencia;

    public Grafo(int vertices) {
        this.vertices = vertices;
        adjacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencia.add(new ArrayList<>());
        }
    }

    // Adicionar aresta (grafo não direcionado)
    public void adicionarAresta(int origem, int destino) {
        adjacencia.get(origem).add(destino);
        adjacencia.get(destino).add(origem);
    }

    // BFS para encontrar o caminho mais curto
    public List<Integer> caminhoMaisCurto(int inicio, int destino) {
        boolean[] visitado = new boolean[vertices];
        Queue<Integer> fila = new LinkedList<>();
        Map<Integer, Integer> pai = new HashMap<>();

        fila.add(inicio);
        visitado[inicio] = true;
        pai.put(inicio, -1);

        while (!fila.isEmpty()) {
            int atual = fila.poll();

            if (atual == destino) {
                return reconstruirCaminho(pai, destino);
            }

            for (int vizinho : adjacencia.get(atual)) {
                if (!visitado[vizinho]) {
                    fila.add(vizinho);
                    visitado[vizinho] = true;
                    pai.put(vizinho, atual);
                }
            }
        }
        return Collections.emptyList(); // nenhum caminho encontrado
    }

    // Reconstrói caminho a partir do mapa de pais
    private List<Integer> reconstruirCaminho(Map<Integer, Integer> pai, int destino) {
        List<Integer> caminho = new ArrayList<>();
        int atual = destino;
        while (atual != -1) {
            caminho.add(atual);
            atual = pai.getOrDefault(atual, -1);
        }
        Collections.reverse(caminho);
        return caminho;
    }
}
