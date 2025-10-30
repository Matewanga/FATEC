package com.nickolss.generalizacao;

public class Administrativo extends Funcionario {
    private String setor;

    public Administrativo(String nome, String cpf, String
            dataAdmissao, String setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
        this.setor = setor;
    }

    public void emitirRelatorio() {
        System.out.println(nome + " emitiu um relatório do setor " +
                setor);
    }
}
