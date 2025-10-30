package com.nickolss.ex04;

import java.util.*;

// Classe que representa um Grafo não direcionado
class Grafo {
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

    // DFS usando pilha que retorna o caminho se existir
    public List<Integer> encontrarCaminho(int inicio, int destino) {
        boolean[] visitado = new boolean[vertices];
        Stack<Integer> pilha = new Stack<>();
        Map<Integer, Integer> pai = new HashMap<>(); // para reconstruir caminho

        pilha.push(inicio);
        pai.put(inicio, -1); // raiz não tem pai

        while (!pilha.isEmpty()) {
            int atual = pilha.pop();

            if (!visitado[atual]) {
                visitado[atual] = true;

                if (atual == destino) {
                    return reconstruirCaminho(pai, destino);
                }

                // Empilhar vizinhos
                for (int vizinho : adjacencia.get(atual)) {
                    if (!visitado[vizinho]) {
                        pilha.push(vizinho);
                        pai.put(vizinho, atual); // registra pai para reconstrução
                    }
                }
            }
        }
        return Collections.emptyList(); // nenhum caminho encontrado
    }

    // Reconstrói caminho usando o mapa de pais
    private List<Integer> reconstruirCaminho(Map<Integer, Integer> pai, int destino) {
        List<Integer> caminho = new ArrayList<>();
        int atual = destino;
        while (atual != -1) {
            caminho.add(atual);
            atual = pai.getOrDefault(atual, -1);
        }
        Collections.reverse(caminho); // inverter para ordem correta
        return caminho;
    }
}