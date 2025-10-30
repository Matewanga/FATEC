package com.nickolss.polimorfismoInclusao;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonificacao() {
        return salario * 0.10;
    }

}
