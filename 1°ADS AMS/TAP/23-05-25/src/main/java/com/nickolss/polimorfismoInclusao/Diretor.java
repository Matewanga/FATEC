package com.nickolss.polimorfismoInclusao;

public class Diretor extends Funcionario {

    public Diretor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonificacao() {
        return salario * 0.20 + 1000.0;
    }

}
