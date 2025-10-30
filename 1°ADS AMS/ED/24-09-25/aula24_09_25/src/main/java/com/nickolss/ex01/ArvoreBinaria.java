package com.nickolss.ex01;

// Classe da Árvore Binária de Busca (BST)
public class ArvoreBinaria {
    private No raiz;

    // Inserir um valor na árvore
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No atual, int valor) {
        if (atual == null) {
            return new No(valor);
        }
        if (valor < atual.valor) {
            atual.esquerda = inserirRecursivo(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRecursivo(atual.direita, valor);
        }
        return atual; // valor já existente não será inserido
    }

    // Buscar um valor na árvore
    public boolean buscar(int valor) {
        return buscarRecursivo(raiz, valor);
    }

    private boolean buscarRecursivo(No atual, int valor) {
        if (atual == null) {
            return false;
        }
        if (valor == atual.valor) {
            return true;
        }
        return valor < atual.valor
                ? buscarRecursivo(atual.esquerda, valor)
                : buscarRecursivo(atual.direita, valor);
    }



    // Percorrer em ordem (in-order): esquerda → raiz → direita
    public void percorrerEmOrdem() {
        percorrerEmOrdemRec(raiz);
        System.out.println();
    }


    private void percorrerEmOrdemRec(No atual) {
        if (atual != null) {
            percorrerEmOrdemRec(atual.esquerda);
            System.out.print(atual.valor + " ");
            percorrerEmOrdemRec(atual.direita);
        }
    }
}
