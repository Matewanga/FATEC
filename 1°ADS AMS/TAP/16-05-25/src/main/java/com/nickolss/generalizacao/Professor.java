package com.nickolss.generalizacao;

public class Professor extends Funcionario {
    private String disciplina;

    public Professor(String nome, String cpf, String dataAdmissao, String disciplina) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.disciplina = disciplina;
    }

    public void ministrarAula() {
        System.out.println(nome + " está ministrando " + disciplina);
    }
}
