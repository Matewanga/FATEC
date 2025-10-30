package com.nickolss.generalizacao;

public class Funcionario {
    protected String nome;
    protected String cpf;
    protected String dataAdmissao;

    public void exibirDados() {
        System.out.println("Nome:" + nome);
        System.out.println("CPF:" + cpf);
        System.out.println("Admissão:" + dataAdmissao);
    }
}
