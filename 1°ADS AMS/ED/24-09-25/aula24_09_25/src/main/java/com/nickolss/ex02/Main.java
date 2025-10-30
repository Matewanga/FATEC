package com.nickolss.ex02;

// Classe principal
public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        // Inserindo elementos
        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(70);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.print("Em ordem: ");
        arvore.emOrdem(arvore.raiz); // 20 30 40 50 60 70 80
        System.out.println();

        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz); // 50 30 20 40 70 60 80
        System.out.println();

        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.raiz); // 20 40 30 60 80 70 50
        System.out.println();

        System.out.print("Por nível: ");
        arvore.porNivel(); // 50 30 70 20 40 60 80
        System.out.println();
    }
}
