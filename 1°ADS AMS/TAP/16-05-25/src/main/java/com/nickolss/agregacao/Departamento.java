package com.nickolss.agregacao;

import java.util.List;

public class Departamento {
    private String nome;
    private List<Funcionario> funcionarios;
    public Departamento(String nome, List<Funcionario>
    funcionarios) {
        this.nome = nome;
        this.funcionarios = funcionarios;
    }
    public void listarFuncionarios() {
        System.out.println("Departamento:" + nome);
        for (Funcionario f : funcionarios) {
            f.exibir();
        }
    }
}
