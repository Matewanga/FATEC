package com.nickolss.especializacao;

public class Main {
    public static void main(String[] args) {
        Professor professor = new Professor("Jorge", "123.456.789-10", "dança");
        Administrativo administrativo = new Administrativo("Juvenal", "432.123.543-10", "11-02-1999", "Financeiro");
        System.out.println("=== PROFESSOR ===");
        professor.exibirDados();
        professor.ministrarAula();

        System.out.println("=== ADMINISTRADOR ===");
        administrativo.exibirDados();
        administrativo.emitirRelatorio();
    }
}
