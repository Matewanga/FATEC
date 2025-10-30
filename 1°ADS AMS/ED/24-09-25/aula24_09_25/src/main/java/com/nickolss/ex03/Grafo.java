package com.nickolss.ex03;

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

    // DFS usando pilha para verificar se existe caminho
    public boolean existeCaminho(int inicio, int destino) {
        boolean[] visitado = new boolean[vertices];
        Stack<Integer> pilha = new Stack<>();

        pilha.push(inicio);

        while (!pilha.isEmpty()) {
            int atual = pilha.pop();

            if (!visitado[atual]) {
                visitado[atual] = true;

                if (atual == destino) {
                    return true; // Caminho encontrado
                }

                // Empilhar vizinhos não visitados
                for (int vizinho : adjacencia.get(atual)) {
                    if (!visitado[vizinho]) {
                        pilha.push(vizinho);
                    }
                }
            }
        }
        return false; // Nenhum caminho encontrado
    }
}