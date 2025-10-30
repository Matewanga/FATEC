package com.nickolss.ex03;

import java.util.Scanner;

// Classe principal
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Definindo quantidade de vértices
        System.out.print("Digite o número de cidades (vértices): ");
        int n = sc.nextInt();

        Grafo grafo = new Grafo(n);

        // Definindo arestas
        System.out.print("Digite o número de estradas (arestas): ");
        int e = sc.nextInt();

        System.out.println("Digite as estradas (pares de cidades origem destino):");
        for (int i = 0; i < e; i++) {
            int origem = sc.nextInt();
            int destino = sc.nextInt();
            grafo.adicionarAresta(origem, destino);
        }

        // Consultando se existe caminho
        System.out.print("Digite a cidade do depósito (início): ");
        int inicio = sc.nextInt();

        System.out.print("Digite a cidade da entrega (destino): ");
        int destino = sc.nextInt();

        if (grafo.existeCaminho(inicio, destino)) {
            System.out.println("✅ Existe um caminho entre o depósito " + inicio + " e a entrega " + destino);
        } else {
            System.out.println("❌ Não existe caminho entre o depósito " + inicio + " e a entrega " + destino);
        }

        sc.close();
    }
}