package com.nickolss.ex01;

// Classe que representa um nó da árvore
public class No {
    int valor;
    No esquerda, direita;

    No(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}


