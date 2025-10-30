package com.nickolss.agregacao;

public class Funcionario {
    private String nome;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public void exibir() {
        System.out.println("Funcionário:" + nome);
    }
}
