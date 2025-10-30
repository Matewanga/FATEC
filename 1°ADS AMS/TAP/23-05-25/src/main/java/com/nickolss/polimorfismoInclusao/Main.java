package com.nickolss.polimorfismoInclusao;

public class Main {

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Carlos", 3000.0);
        Funcionario f2 = new Gerente("Luciana", 5000.0);
        Funcionario f3 = new Diretor("Roberto", 10000.0);

        f1.exibirInformacoes();
        f2.exibirInformacoes();
        f3.exibirInformacoes();
    }

}
