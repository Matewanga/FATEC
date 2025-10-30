package com.nickolss.ex01;

public class Main {

    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(50);
        arvoreBinaria.inserir(30);
        arvoreBinaria.inserir(70);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(40);
        arvoreBinaria.inserir(60);
        arvoreBinaria.inserir(80);

        System.out.println("Elementos");
        arvoreBinaria.percorrerEmOrdem();

        System.out.printf("Buscar o número 40: %b\n", arvoreBinaria.buscar(40));
        System.out.printf("Buscar o número 90: %b\n", arvoreBinaria.buscar(90));
    }
}