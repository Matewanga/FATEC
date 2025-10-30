package com.nickolss.agregacao;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Ana");
        Funcionario f2 = new Funcionario("Carlos");
        Departamento dp = new Departamento("Tecnologia",
                Arrays.asList(f1, f2));
        dp.listarFuncionarios();
    }
}