package com.nickolss.polimorfismoInclusao;

public class Funcionario {

    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;

    }

    public double calcularBonificacao() {
        return salario * 0.05;
    }

    public void exibirInformacoes() {
        System.out.println(nome + " - Bonificação: R$ " + calcularBonificacao());
    }

}
