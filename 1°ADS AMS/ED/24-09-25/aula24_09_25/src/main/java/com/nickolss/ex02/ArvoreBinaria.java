package com.nickolss.ex02;

import java.util.LinkedList;
import java.util.Queue;

// Classe da Árvore Binária
public class ArvoreBinaria {
    No raiz;

    // Inserção simples em árvore de busca
    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }
        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        }
        return atual;
    }

    // Percurso em ordem (in-order): esquerda → raiz → direita
    public void emOrdem(No atual) {
        if (atual != null) {
            emOrdem(atual.esquerda);
            System.out.print(atual.valor + " ");
            emOrdem(atual.direita);
        }
    }

    // Percurso pré-ordem (pre-order): raiz → esquerda → direita
    public void preOrdem(No atual) {
        if (atual != null) {
            System.out.print(atual.valor + " ");
            preOrdem(atual.esquerda);
            preOrdem(atual.direita);
        }
    }

    // Percurso pós-ordem (post-order): esquerda → direita → raiz
    public void posOrdem(No atual) {
        if (atual != null) {
            posOrdem(atual.esquerda);
            posOrdem(atual.direita);
            System.out.print(atual.valor + " ");
        }
    }

    // Percurso por nível (level-order ou BFS)
    public void porNivel() {
        if (raiz == null) return;

        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }
}
