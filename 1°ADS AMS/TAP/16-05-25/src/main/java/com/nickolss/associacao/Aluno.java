package com.nickolss.associacao;

public class Aluno {
    String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public void mostrarCurso(Curso curso) {
        System.out.println(nome + "está matriculado no curso de " + curso.nome);
    }
}
