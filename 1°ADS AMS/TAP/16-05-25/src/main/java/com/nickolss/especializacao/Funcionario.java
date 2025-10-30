package com.nickolss.especializacao;

public class Funcionario {
    protected String nome;
    protected String cpf;

    public void exibirDados() {
        System.out.println("Nome:" + nome);
        System.out.println("CPF:" + cpf);
    }
}
